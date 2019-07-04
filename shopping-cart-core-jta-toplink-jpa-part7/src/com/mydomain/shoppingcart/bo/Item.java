package com.mydomain.shoppingcart.bo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * @author Ross
 */
@Entity
@Table(name="item")
public class Item implements Serializable  {
	private static final long serialVersionUID = 1135428828106917172L;
	private String description;
	private Long id;
	private String name;
	private Double price;
	private List<BasketItem> basketItems = new ArrayList<BasketItem>(0);
	
	public Item() {
	}

	public Item(Long id, String name, double price) {
		this.id = id;
		this.name = name;
		this.price = price;
	}

	public Item(Long id, String description, String name, double price) {
		this.id = id;
		this.description = description;
		this.name = name;
		this.price = price;
	}
	
	@Column(name="description")
	public String getDescription() {
		return this.description;
	}

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	public Long getId() {
		return this.id;
	}

	@Column(name="name", nullable=false)
	public String getName() {
		return this.name;
	}

	@Column(name="price", nullable=false, precision=22, scale=0)
	public Double getPrice() {
		return this.price;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setPrice(Double price) {
		this.price = price;
	}
	
	@OneToMany(mappedBy="item", cascade=CascadeType.ALL)
	public List<BasketItem> getBasketItems() {
		return this.basketItems;
	}

	public void setBasketItems(List<BasketItem> basketItems) {
		this.basketItems = basketItems;
	}
}

