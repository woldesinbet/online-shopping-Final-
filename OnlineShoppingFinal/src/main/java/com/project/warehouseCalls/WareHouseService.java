package com.project.warehouseCalls;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.project.model.Cart;
import com.project.model.CartItem;
import com.project.model.Customer;
import com.project.model.Product;
import com.project.repository.CustomerRepository;

@Service
public class WareHouseService {
	private static final String SKU_CREATION_REQUEST_PATH = "http://localhost:8093//warehouse/skuCreationRequest";
	private static final String SHIPPING_REQUEST_PATH = "http://localhost:8093//warehouse/shippingRequest";

	@Autowired
	CustomerRepository cRepository;

	public void sendProductCreationRequest(Product newProduct) {
		RestTemplate restTemplate = new RestTemplate();
		SKUCreationRequest cRequest = new SKUCreationRequest(newProduct.getProductid(), newProduct.getName(),
				newProduct.getPrice(), newProduct.getDesribtion(), newProduct.getQuantitiy());

		ResponseEntity<SKUCreationRequest> rRequest = restTemplate
				.postForEntity(WareHouseService.SKU_CREATION_REQUEST_PATH, cRequest, SKUCreationRequest.class);

		if (rRequest.getBody() == null) {
			throw new RuntimeException("Unable to create product. Warehouse system not responding.");
		}
	}

	public void sendShippingRequest(Cart cart) {
		Customer customer = this.cRepository.findByAccountUsername(cart.getAccount().getUsername());
		String fullNameOfCutomer = customer.getFirstname() + " " + customer.getLastlame();
		String destination = cart.getDestination();
		CartRequested request = new CartRequested(fullNameOfCutomer, destination);

		for (CartItem item : cart.getCartItems()) {
			ItemInRequestedCart sItem = new ItemInRequestedCart(item.getProduct().getProductid(), item.getQuantity());
			request.addItem(sItem);
		}

		RestTemplate restTemplate = new RestTemplate();
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));

		HttpEntity<String> entity = new HttpEntity<String>("parameters", headers);
		ResponseEntity<CartRequested> rRequest = restTemplate.postForEntity(WareHouseService.SHIPPING_REQUEST_PATH,
				request, CartRequested.class);
		if (!rRequest.hasBody()) {
			throw new RuntimeException("Unable to create product. Warehouse system not responding.");
		}

	}
}
