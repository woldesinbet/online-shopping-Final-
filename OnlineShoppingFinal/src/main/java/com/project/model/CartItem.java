package com.project.model;

import java.math.BigDecimal;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class CartItem {

	@GeneratedValue
	@Id
	private Long id;
	@ManyToOne(cascade = CascadeType.PERSIST)
	private Product product;
	private int quantity;
	@ManyToOne(optional = false)
	private Cart cart;

	CartItem() {
	}

	public CartItem(Product product, Cart cart) {
		this.cart = cart;
		this.product = product;
		this.quantity = 1;
	}

	public void addQuantity() {
		this.quantity++;
	}

	public BigDecimal getTotalPrice() {
		BigDecimal price = this.product.getPrice().multiply(new BigDecimal(this.quantity));
		return price;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	
}
