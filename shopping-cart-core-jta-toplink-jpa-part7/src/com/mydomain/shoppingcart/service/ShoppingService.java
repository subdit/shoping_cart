package com.mydomain.shoppingcart.service;

import java.util.Collection;

import com.mydomain.shoppingcart.bo.Basket;
import com.mydomain.shoppingcart.bo.BasketItem;
import com.mydomain.shoppingcart.bo.Item;
import com.mydomain.shoppingcart.exception.ShoppingException;

/** 
 * @author Ross
 */
public interface ShoppingService {
	public void deleteBasket(Basket basket) throws ShoppingException;

	public Collection<Item> findItems() throws ShoppingException;
	
	public Basket updateBasket(Basket basket) throws ShoppingException;
	
	public Basket removeItemFromBasket(BasketItem basketItem) throws ShoppingException;
}