package com.mydomain.shoppingcart.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.mydomain.shoppingcart.bo.Item;
import com.mydomain.shoppingcart.dao.ItemDao;
import com.mydomain.shoppingcart.util.JPAUtil;

/** 
 * @author Ross
 */
@PersistenceContext(name="persistence/ShoppingCart", unitName="shopping-cart")
public class ItemDaoImpl implements ItemDao {

	@SuppressWarnings("unchecked")
	public List<Item> list() throws Exception {
		try {
			EntityManager em = JPAUtil.getEntityManager();
			return em.createQuery("select item from Item as item").getResultList();
		} catch (Exception e) {
			throw e;
		}
	}

	public Item load(Long id) throws Exception {
		try {
			EntityManager em = JPAUtil.getEntityManager();
			return (Item) em.find(Item.class, id);
		} catch (Exception e) {
			throw e;
		}
	}

}
