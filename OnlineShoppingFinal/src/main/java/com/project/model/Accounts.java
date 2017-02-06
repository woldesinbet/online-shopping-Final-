package com.project.model;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.hibernate.annotations.NaturalId;

@Entity
public class Accounts {
	@Id
	@GeneratedValue
	private long id;
	@NaturalId
	private String username;
	private String password;

	private boolean enabled;
	@Enumerated(EnumType.STRING)
	private Role hasRole;

	public Role getRole() {
		return hasRole;
	}

	public void setRole(Role role) {
		this.hasRole = role;
	}

	/*public Customer getUser() {
		return user;
	}*/

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	/*public void setUser(Customer user) {
		this.user = user;
	}
*/
	/*@OneToOne
	private Paymentinfo payment;
	@OneToMany
	private List<Orders> orders;
	@OneToOne
	private Customer user;

	public List<Orders> getOrders() {
		return orders;
	}

	public void setOrders(List<Orders> orders) {
		this.orders = orders;
	}

	public Paymentinfo getPayment() {
		return payment;
	}

	public void setPayment(Paymentinfo payment) {
		this.payment = payment;
	}
*/
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
