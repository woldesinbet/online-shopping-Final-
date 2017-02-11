package com.project.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.project.model.Cart;
import com.project.model.Payment;
import com.project.repository.CartRepository;
import com.project.repository.CheckoutRepository;
@Transactional
@Service
public class CheckoutService {
	@Autowired
	CheckoutRepository checkoutrepository;
	@Autowired
	CartRepository cartRepository;

	public Cart checkout(String username, Payment payment) {
		System.out.println("method called.");
		Cart cart = this.cartRepository.findNewCartOfCutomer(username);
		payment = this.checkoutrepository.save(payment);
		System.out.println("Saved payment: " + payment);
		cart.checkout(payment);
		Cart savedCart = this.cartRepository.save(cart);
		System.out.println("Saved Cart: " + cart);
		return savedCart;
	}

}
