package com.mydomain.shoppingcart.exception;

import java.io.Serializable;

/** 
 * @author Kasidit
 */
public class ShoppingException extends Exception implements Serializable {
	private static final long serialVersionUID = 4803035244998352308L;

	public ShoppingException() {
		super();
	}
	
	public ShoppingException(String message) {
		super(message);
	}
	
	public ShoppingException(String message, Throwable cause) {
		super(message, cause);
	}
}
