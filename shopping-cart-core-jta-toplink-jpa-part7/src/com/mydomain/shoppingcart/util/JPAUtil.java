package com.mydomain.shoppingcart.util;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.persistence.EntityManager;
import javax.transaction.UserTransaction;

/** 
 * @author Ross
 */
public class JPAUtil {

	public static UserTransaction getUserTransaction() throws NamingException {
		Context ctx = new InitialContext();
		return (UserTransaction)ctx.lookup("java:comp/UserTransaction");
	}
	
	private static final EntityManager em;
	static {
		try {
			Context ctx = new InitialContext();
		    em =  (EntityManager) ctx.lookup("java:comp/env/persistence/ShoppingCart");
		} catch (Throwable ex) {
			System.err.println("Initial EntityManager creation failed." + ex);
			throw new ExceptionInInitializerError(ex);
		}
	}

	public static EntityManager getEntityManager() {
		return em;
	}
}
