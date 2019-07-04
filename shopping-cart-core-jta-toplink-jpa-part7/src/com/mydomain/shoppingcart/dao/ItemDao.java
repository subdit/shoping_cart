package com.mydomain.shoppingcart.dao;

import java.util.List;

import com.mydomain.shoppingcart.bo.Item;

/** 
 * @author Ross
 */
public interface ItemDao {
	public List<Item> list() throws Exception;
	public Item load(Long id) throws Exception;
}
