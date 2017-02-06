package com.project.warehouseCalls;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class CartRequested implements Serializable {

	private static final long serialVersionUID = 1L;
	private String fullNameOfCutomer;
	private List<ItemInRequestedCart> items = new ArrayList<ItemInRequestedCart>();
	private String destination;

	public CartRequested() {
	}

	public CartRequested(String fullNameOfCutomer, String destination) {
		super();
		this.fullNameOfCutomer = fullNameOfCutomer;
		this.destination = destination;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String address) {
		this.destination = address;
	}

	public String getFullNameOfCutomer() {
		return fullNameOfCutomer;
	}

	public void setFullNameOfCutomer(String fullNameOfCutomer) {
		this.fullNameOfCutomer = fullNameOfCutomer;
	}

	public void addItem(ItemInRequestedCart item) {
		this.items.add(item);
	}

	public List<ItemInRequestedCart> getItems() {
		return items;
	}

	public void setItems(List<ItemInRequestedCart> items) {
		this.items = items;
	}

	@Override
	public String toString() {
		return "CartRequested [fullNameOfCutomer=" + fullNameOfCutomer + ", items=" + items + ", destination="
				+ destination + "]";
	}

}
