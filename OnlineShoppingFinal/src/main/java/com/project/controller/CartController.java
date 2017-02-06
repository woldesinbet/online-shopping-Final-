package com.project.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.project.model.Cart;
import com.project.service.CartService;

@Controller
public class CartController {

	@Autowired
	CartService cartService;

	@RequestMapping("/addToCart/{pid}")
	public String addProductToCart(@PathVariable("pid") Long pId, Principal principal, RedirectAttributes redirAttr) {
		String username = principal.getName();
		Cart cart = this.cartService.addProductToCart(pId, username);
		redirAttr.addFlashAttribute("cart", cart);
		return "redirect:/cart";
	}

	@RequestMapping("/removeFromCart/{pid}")
	public String removeProductFromCart(@PathVariable("pid") long pId, Principal principal,
			RedirectAttributes redirAttr) {
		String username = principal.getName();
		Cart cart = this.cartService.removeProductFromCart(pId, username);
		redirAttr.addFlashAttribute("cart", cart);
		return "redirect:/cart";
	}

	@RequestMapping("/cart")
	public String getCart(Principal principal, Model model) {
		String username = principal.getName();
		Cart cart = this.cartService.getUserCart(username);
		model.addAttribute("cart", cart);
		return "cart";
	}

	@PostMapping("/cart/remove")
	public @ResponseBody void ship(Long productId, Long cartId) {
		if (productId == null || cartId == null) {
			throw new RuntimeException("Porduct id and cart id required.");
		}
		Cart cart = this.cartService.removeProductFromCart(productId, cartId);
	}

}
