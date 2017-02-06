package com.project.warehouseCalls;

import java.math.BigDecimal;


public class SKUCreationRequest {
	private Long id;
	private Long productId;
	private String name;
	private BigDecimal price;
	private String desribtion;	
	private int quantitiy;

	SKUCreationRequest() {
	}

	public SKUCreationRequest(Long productId, String name, BigDecimal price, String desribtion, int quantitiy) {
		super();
		this.productId = productId;
		this.name = name;
		this.price = price;
		this.desribtion = desribtion;
		this.quantitiy = quantitiy;
	}

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public String getDesribtion() {
		return desribtion;
	}

	public void setDesribtion(String desribtion) {
		this.desribtion = desribtion;
	}

	public int getQuantitiy() {
		return quantitiy;
	}

	public void setQuantitiy(int quantitiy) {
		this.quantitiy = quantitiy;
	}

	public Long getProductId() {
		return productId;
	}

	public void setProductId(Long productId) {
		this.productId = productId;
	}

}
