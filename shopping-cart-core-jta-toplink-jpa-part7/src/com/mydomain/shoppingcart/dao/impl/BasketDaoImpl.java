package com.mydomain.shoppingcart.dao.impl;

import java.util.Iterator;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.UserTransaction;

import com.mydomain.shoppingcart.bo.Basket;
import com.mydomain.shoppingcart.bo.BasketItem;
import com.mydomain.shoppingcart.dao.BasketDao;
import com.mydomain.shoppingcart.util.JPAUtil;

/** 
 * @author Ross
 */
@PersistenceContext(name="persistence/ShoppingCart", unitName="shopping-cart")
public class BasketDaoImpl implements BasketDao {

	public void delete(Basket basket) throws Exception {
		UserTransaction utx = null;
		try {
			EntityManager em = JPAUtil.getEntityManager();
			utx = JPAUtil.getUserTransaction();
			utx.begin();
			basket = em.find(Basket.class, basket.getId());
			em.remove(basket);
			utx.commit();
		} catch (RuntimeException e) {
			if (utx != null) {
				utx.rollback();
			}	
			throw e;
		}
	}

	public Basket updateBasket(Basket basket) throws Exception {
		UserTransaction utx = null;
		try {
			EntityManager em = JPAUtil.getEntityManager();
			utx = JPAUtil.getUserTransaction();
			utx.begin();
			basket = em.merge(basket);
			utx.commit();
			return basket;
		} catch (RuntimeException e) {
			if (utx != null) {
				utx.rollback();
			}	
			throw e;
		}
	}
	
	public Basket removeItemFromBasket(BasketItem basketItem) throws Exception {
		UserTransaction utx = null;
		try {
			EntityManager em = JPAUtil.getEntityManager();
			utx = JPAUtil.getUserTransaction();
			utx.begin();
			Basket basket = em.find(Basket.class, basketItem.getBasket().getId());
			for (Iterator<BasketItem> it = basket.getBasketItems().iterator(); it.hasNext(); ) {
				BasketItem existingBasketItem = (BasketItem) it.next();
				if (existingBasketItem.getId().equals(basketItem.getId())) {
					if (existingBasketItem.getQuantity() > 1) {
						existingBasketItem.decreaseQuantity();
					} else {
						it.remove();
					}
				}
			};
			basket = em.merge(basket);
			utx.commit();
			return basket;
		} catch (RuntimeException e) {
			if (utx != null) {
				utx.rollback();
			}	
			throw e;
		}
	}
}
