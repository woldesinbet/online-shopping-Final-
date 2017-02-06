package com.project.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Cart {
	@GeneratedValue
	@Id
	private Long id;
	@OneToMany(mappedBy = "cart", cascade = CascadeType.ALL)
	private List<CartItem> cartItems = new ArrayList<CartItem>();
	@Enumerated(EnumType.STRING)
	private CartStatus status;
	@ManyToOne
	@NotNull
	private Accounts account;
	@JsonIgnore
	@OneToOne(cascade = CascadeType.ALL)
	private Payment payment;

	Cart() {
	}

	public Cart(Accounts account) {
		this.status = CartStatus.NEW;
		this.account = account;
	}

	public CartItem addProduct(Product product) {
		product.decreaseQuantitiy();
		CartItem cItem = this.find(product);
		if (cItem != null) {
			cItem.addQuantity();
		} else {
			cItem = new CartItem(product, this);
		}
		return cItem;
	}

	public CartItem removeProduct(Product product) {
		CartItem cItem = this.find(product);
		if (cItem != null) {
			this.cartItems.remove(cItem);
			product.addQuantitiy(cItem.getQuantity());
			return cItem;
		}
		return null;
	}

	public void checkout(Payment payment) {
		
		if (this.status == CartStatus.SHIPPED || this.status == CartStatus.CHECKED_OUT) {
			throw new RuntimeException("Item already shipped or checkout.");
		}
		
		this.payment = payment;
		this.payment.setAmount(this.getTotalPrice());
		this.status = CartStatus.CHECKED_OUT;
	}

	public void shipItem() {
		if (cartItems.isEmpty()) {
			new RuntimeException("The cart is empty.");
		}
		this.status = CartStatus.SHIPPED;
	}

	public BigDecimal getTotalPrice() {
		BigDecimal total = new BigDecimal(0);
		for (CartItem cItem : cartItems) {
			total = total.add(cItem.getTotalPrice());
		}
		return total;
	}

	public List<CartItem> getCartItems() {
		return new ArrayList<CartItem>(this.cartItems);
	}

	private CartItem find(Product product) {
		for (CartItem cItem : this.cartItems) {
			if (product.getProductid() == cItem.getProduct().getProductid()) {
				return cItem;
			}
		}
		return null;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public CartStatus getStatus() {
		return status;
	}

	public void setStatus(CartStatus status) {
		this.status = status;
	}

	public Accounts getAccount() {
		return account;
	}

	public void setAccount(Accounts account) {
		this.account = account;
	}

	public void setCartItems(List<CartItem> cartItems) {
		this.cartItems = cartItems;
	}

	public String getDestination() {
		return this.payment.getDestination();
	}

}
