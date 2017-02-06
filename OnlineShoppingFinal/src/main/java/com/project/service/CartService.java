package com.project.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.model.Accounts;
import com.project.model.Cart;
import com.project.model.CartItem;
import com.project.model.Product;
import com.project.repository.AccountRepository;
import com.project.repository.CartItemRepository;
import com.project.repository.CartRepository;
import com.project.repository.ProductRepository;

@Transactional
@Service
public class CartService {
	@Autowired
	CartRepository cartRepository;
	@Autowired
	ProductRepository productRepository;
	@Autowired
	AccountRepository accountRepository;
	@Autowired
	CartItemRepository CartItemRepository;

	public Cart addProductToCart(long pId, String username) {
		Cart c = cartRepository.findNewCartOfCutomer(username);
		Product p = productRepository.findOne(pId);

		if (p == null || p.getQuantitiy() == 0) {
			throw new RuntimeException("Product is out of stock.");
		}

		if (c == null) {
			Accounts account = this.accountRepository.findByUsername(username);
			c = new Cart(account);
		}

		CartItem cItem =c.addProduct(p);		
		c = this.cartRepository.save(c);
		this.CartItemRepository.save(cItem);
		this.productRepository.save(p);
		return c;
	}

	public Cart removeProductFromCart(long pId, String username) {
		Cart c = cartRepository.findNewCartOfCutomer(username);
		Product p = productRepository.findOne(pId);
		if (c == null) {
			throw new RuntimeException("Cart not found.");
		}
		c.removeProduct(p);
		c = this.cartRepository.save(c);
		this.productRepository.save(p);
		return c;
	}

	public Cart getUserCart(String username) {
		Cart c = this.cartRepository.findNewCartOfCutomer(username);
		Accounts account = this.accountRepository.findByUsername(username);
		if (c == null) {
			c = new Cart(account);
		}
		return c;
	}

	public Cart findOne(Long cartId) {
		return this.cartRepository.findOne(cartId);
	}

	public Cart removeProductFromCart(Long productId, Long cartId) {
		Cart c = cartRepository.findOne(cartId);
		Product p = productRepository.findOne(productId);
		if (c == null) {
			throw new RuntimeException("Cart not found.");
		}
		System.out.println("Number of items before removed: "+c.getCartItems().size());		
		System.out.println(p.getQuantitiy());
		CartItem cItem = c.removeProduct(p);
		this.CartItemRepository.delete(cItem);
		this.productRepository.save(p);
		c =this.cartRepository.save(c);
				
		System.out.println("Number of items after removed: "+c.getCartItems().size());
		System.out.println(p.getQuantitiy());

		return c;
	}
}
