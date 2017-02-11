package com.project.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.model.Product;
import com.project.repository.ProductRepository;
@Transactional
@Service
public class ProductService {
	@Autowired
	ProductRepository productRepository;

	public Product addProduct(Product product) {
		return productRepository.save(product);
	}

	public List<Product> viewProduct() {
		return (List<Product>) productRepository.findAllNotFinished();
	}

	public void delete(long id) {
		productRepository.delete(id);
	}

	public Product viewById(long id) {
		return productRepository.findOne(id);
	}

}
