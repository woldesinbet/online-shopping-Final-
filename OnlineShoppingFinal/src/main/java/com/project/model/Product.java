package com.project.model;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Product {
	@Id
	@GeneratedValue
	private long productid;
	private String name;
	private BigDecimal price;
	private String desribtion;
	private int quantitiy;

	@OneToOne
	private Category assignedcategory;

	public Category getAssignedcategory() {
		return assignedcategory;
	}

	public void setAssignedcategory(Category assignedcategory) {
		this.assignedcategory = assignedcategory;
	}

	public long getProductid() {
		return productid;
	}

	public void setProductid(long productid) {
		this.productid = productid;
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
		if (quantitiy <= 0) {
			throw new RuntimeException("Quantity should be greater than 0.");
		}
		this.quantitiy = quantitiy;
	}

	public void addQuantitiy(int quantity) {
		if (quantitiy <= 0) {
			throw new RuntimeException("Quantity should be greater than 0.");
		}
		this.quantitiy = this.quantitiy + quantity;
	}

	public void decreaseQuantitiy() {
		if (quantitiy <= 0) {
			throw new RuntimeException("Quantity should be greater than 0.");
		}
		this.quantitiy = this.quantitiy - 1;
	}
}
