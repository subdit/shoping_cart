package com.mydomain.shoppingcart.bo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.eclipse.persistence.annotations.PrivateOwned;

/** 
 * @author Ross
 */
@Entity
@Table(name="basket")
public class Basket implements Serializable {
	private static final long serialVersionUID = -2167377483998323379L;
	private Long id;
	private List<BasketItem> basketItems = new ArrayList<BasketItem>(0);

	public Basket() {
	}

	public Basket(Long id) {
		this.id = id;
	}

	public void addItem(Item item) {
		boolean itemExists = false;
		for (BasketItem basketItem : getBasketItems()) {
			if (basketItem.getItem().getId().equals(item.getId())) {
				basketItem.increaseQuantity();
				basketItem.setPrice(basketItem.getItem().getPrice() * basketItem.getQuantity());
				itemExists = true;
			}
		}
		if (!itemExists) {
			BasketItem basketItem = new BasketItem(this, item, 1, item.getPrice());
			getBasketItems().add(basketItem);
		}
	}

	public void empty() {
		setBasketItems(new ArrayList<BasketItem>(0));
	}
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@OneToMany(mappedBy="basket", cascade=CascadeType.ALL)
	@PrivateOwned
	public List<BasketItem> getBasketItems() {
		return this.basketItems;
	}

	public void setBasketItems(List<BasketItem> basketItems) {
		this.basketItems = basketItems;
	}

	@Transient
	public int getItemCount() {
		return getBasketItems().size();
	}
}