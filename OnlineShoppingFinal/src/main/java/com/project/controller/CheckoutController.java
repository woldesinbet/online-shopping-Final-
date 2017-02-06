package com.project.controller;

import java.security.Principal;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.project.model.Cart;
import com.project.model.Payment;
import com.project.service.CheckoutService;
import com.project.warehouseCalls.WareHouseService;

@Controller
public class CheckoutController {
	@Autowired
	CheckoutService checkoutservice;
	@Autowired
	private WareHouseService warehouseService;

	@RequestMapping(value = { "/checkout" }, method = RequestMethod.GET)
	public String makePayement(Payment payment) {
		return "checkout";
	}

	@RequestMapping(value = { "/checkout" }, method = RequestMethod.POST)
	public String addPayment(@Valid Payment payment, BindingResult validator, Principal principal) {
		if (validator.hasErrors()) {
			return "/checkout";
		}
		String username = principal.getName();
		Cart cart = checkoutservice.checkout(username, payment);
		this.warehouseService.sendShippingRequest(cart);
		return "redirect:/checkoutSucess";
	}

	@RequestMapping("/checkoutSucess")
	public String sucess() {
		
		return "successPage";
	}

}
