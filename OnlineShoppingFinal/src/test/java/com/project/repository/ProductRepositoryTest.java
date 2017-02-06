package com.project.repository;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.jdbc.EmbeddedDatabaseConnection;
import org.springframework.boot.test.autoconfigure.orm.jpa.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;


import com.project.model.Product;


@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("test")

/*@DataJpaTest
@AutoConfigureTestDatabase(connection = EmbeddedDatabaseConnection.H2)
*/public class ProductRepositoryTest {
	@Autowired
	ProductRepository productRepository;
	@Test
	public void testSave() {
		Product product = new Product();
		product.setDesribtion("description of product");
		product.setName("product name");
		productRepository.save(product );
		assertTrue("Product should be saved to database..", product.getProductid() > 0);
	}
	
	@Test
	public void testFindeOne() {
		Product product = new Product();
		product.setDesribtion("description of product");
		product.setName("product name");
		productRepository.save(product);
		Product productFound = productRepository.findOne(product.getProductid());
		assertEquals("Product should be found.", productFound.getProductid(), product.getProductid());
	}
	@Test
	public void testFindAll() {
		Product product = new Product();
		product.setDesribtion("description of product");
		productRepository.save(product);
		List<Product> products = (List<Product>) productRepository.findAll();
		assertTrue("Returned list must not be empty",! products.isEmpty());
	}
	@Test
	public void testDelete() {
		Product product = new Product();
		product .setDesribtion("description of product");
		product .setName("product name");
		productRepository.save(product);
		productRepository.delete(product.getProductid());
		Product productFound = productRepository.findOne(product.getProductid());
		assertNull("product should be deleted from database.", productFound );
		
	}
}


