package com.mydomain.shoppingcart.service.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.mydomain.shoppingcart.bo.Basket;
import com.mydomain.shoppingcart.bo.Item;
import com.mydomain.shoppingcart.service.ShoppingService;
import com.mydomain.shoppingcart.service.impl.ShoppingManager;

/** 
 * @author Ross
 */
public class ShoppingServiceTest {
	private Basket basket;
	private ShoppingService shoppingManager;
	private Item testItem;
	private int itemsCount;
	
	/**
	 * Tests adding an item to the basket.
	 */
	@Test
	public void addItem() {
		int itemCount = basket.getItemCount();
		basket.addItem(testItem);
		assertEquals(itemCount + 1, basket.getItemCount());
	}

	/**
	 * Tests emptying the basket.
	 */
	@Test
	public void empty() {
		basket.empty();
		assertEquals(0, basket.getItemCount());
	}

	/**
	 * Tests finding items.
	 */
	@Test
	public void findItems() {
		try {
			List<Item> allItems = new ArrayList<Item>(shoppingManager.findItems());
			assertEquals(itemsCount, allItems.size());
		} catch (Exception e) {
			fail("Error in Shopping Manager");
		}
	}

	/**
	 * Sets up the test fixture.
	 * 
	 * Called before every test case method.
	 */
	@Before
	public void setUp() {
		shoppingManager = new ShoppingManager();
        try {
			itemsCount = shoppingManager.findItems().size();
			testItem = new Item(1l, "Candy Cotton", "Candy coated milky tarts", 8.50d);
			basket = new Basket();
			basket.addItem(new Item(2l, "Jelly Beans", "Jelly icecream waffle cream", 18.99d));
			basket.addItem(new Item(3l, "Jam Doughnut", "Strawberry jam and Christmas pudding", 23.00d));
        } catch (Exception e) {
			fail("Error setting up test case");
		}
	}
}
