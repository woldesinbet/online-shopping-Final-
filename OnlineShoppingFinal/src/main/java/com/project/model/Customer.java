package com.project.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
///
public class Customer {
	@Id
	@GeneratedValue
	private long id;
	private String firstname;
	private String lastname;

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	@OneToOne(cascade = CascadeType.ALL)
	private Accounts account;
	@OneToOne(cascade = CascadeType.ALL)
	Address assignedAddress;

	public Address getAssignedAddress() {
		return assignedAddress;
	}

	public void setAssignedAddress(Address assignedAddress) {
		this.assignedAddress = assignedAddress;
	}

	public Accounts getAccount() {
		return account;
	}

	public void setAccount(Accounts account) {
		this.account = account;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastlame() {
		return lastname;
	}

	public void setLastlame(String lastlame) {
		this.lastname = lastlame;
	}

}
