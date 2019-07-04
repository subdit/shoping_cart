package com.mydomain.shoppingcart.service.impl;

import java.util.Collection;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mydomain.shoppingcart.bo.Basket;
import com.mydomain.shoppingcart.bo.BasketItem;
import com.mydomain.shoppingcart.bo.Item;
import com.mydomain.shoppingcart.dao.BasketDao;
import com.mydomain.shoppingcart.dao.ItemDao;
import com.mydomain.shoppingcart.dao.impl.BasketDaoImpl;
import com.mydomain.shoppingcart.dao.impl.ItemDaoImpl;
import com.mydomain.shoppingcart.exception.ShoppingException;
import com.mydomain.shoppingcart.service.ShoppingService;

/**
 * @author Ross
 */
public class ShoppingManager implements ShoppingService {
	private static final Logger logger = LoggerFactory.getLogger(ShoppingManager.class);
	private BasketDao basketDao;
	private ItemDao itemDao;

	public void deleteBasket(Basket basket) throws ShoppingException {
		try {
			getBasketDao().delete(basket);
		} catch (Exception e) {
			logger.error("There was an error deleting a basket, exception: " + e);
			throw new ShoppingException("There was an error deleting a basket", e);
		}
	}

	public Collection<Item> findItems() throws ShoppingException {
		try {
			return getItemDao().list();
		} catch (Exception e) {
			logger.error("There was an error finding all the items, exception: " + e);
			throw new ShoppingException("There was an error finding all the items", e);
		}
	}

	public BasketDao getBasketDao() {
		if (basketDao == null) {
			basketDao = new BasketDaoImpl();
		}
		return basketDao;
	}

	public ItemDao getItemDao() {
		if (itemDao == null) {
			itemDao = new ItemDaoImpl();
		}
		return itemDao;
	}

	public Basket updateBasket(Basket basket) throws ShoppingException {
		try {
			return getBasketDao().updateBasket(basket);
		} catch (Exception e) {
			logger.error("There was an error updating the basket, exception: " + e);
			throw new ShoppingException("There was an error updating the basket", e);
		}
	}
	
	public Basket removeItemFromBasket(BasketItem basketItem) throws ShoppingException {
		try {
			return getBasketDao().removeItemFromBasket(basketItem);
		} catch (Exception e) {
			logger.error("There was an error updating the basket, exception: " + e);
			throw new ShoppingException("There was an error updating the basket", e);
		}
	}
}