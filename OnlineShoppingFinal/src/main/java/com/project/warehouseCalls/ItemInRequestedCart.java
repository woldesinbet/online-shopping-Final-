package com.project.warehouseCalls;

import java.io.Serializable;

public class ItemInRequestedCart implements Serializable {

	private static final long serialVersionUID = 1L;
	private int quantity;
	private Long productId;

	public ItemInRequestedCart() {
	}

	public ItemInRequestedCart(Long productId, int quantity) {
		super();
		this.productId = productId;
		this.quantity = quantity;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public Long getProductId() {
		return productId;
	}

	public void setProductId(Long productId) {
		this.productId = productId;
	}

}
