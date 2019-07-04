package com.mydomain.shoppingcart.bo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * @author Ross
 */
@Entity
@Table(name="basket_item")
public class BasketItem implements java.io.Serializable {
	private static final long serialVersionUID = -8546520439011611132L;
	private Long id;
	private Basket basket;
	private Item item;
	private int quantity;
	private double price;

	public BasketItem() {
	}

	public BasketItem(Basket basket, Item item, int quantity,
			double price) {
		this.basket = basket;
		this.item = item;
		this.quantity = quantity;
		this.price = price;
	}

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@ManyToOne
	@JoinColumn(name="basket_id", nullable=false)
	public Basket getBasket() {
		return this.basket;
	}
	
	public void setBasket(Basket basket) {
		this.basket = basket;
	}

	@ManyToOne
	@JoinColumn(name="items_id", nullable=false)
	public Item getItem() {
		return this.item;
	}

	public void setItem(Item item) {
		this.item = item;
	}

	@Column(name="quantity", nullable=false)
	public int getQuantity() {
		return this.quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	@Column(name="price", nullable=false, precision=22, scale=0)
	public double getPrice() {
		return this.price;
	}

	public void setPrice(double price) {
		this.price = price;
	}
	
	public void increaseQuantity() {
		quantity += 1;
	}
	
	public void decreaseQuantity() {
		quantity -= 1;
	}
}
