package com.project.service;

import static org.junit.Assert.*;

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

@SpringBootTest
@RunWith(SpringRunner.class)
@ActiveProfiles("test")

/*@DataJpaTest
@AutoConfigureTestDatabase(connection = EmbeddedDatabaseConnection.H2)
*/public class ProductServiceTest {
	@Autowired
	ProductService productService;
	@Test
	public void testAddProduct() {
		Product product = new Product();
		product.setDesribtion("description of product");
		product.setName("product name");
		productService.addProduct(product);
		assertTrue("product should be saved to database..", product.getProductid()> 0);
	
	}
	@Test
	public void testViewById() {
		Product product = new Product();
		product.setDesribtion("description of product");
		product.setName("product name");
		productService.addProduct(product);
		Product productFound = productService.viewById(product.getProductid());
		assertEquals("product should be found.", productFound.getProductid(), product.getProductid());
	}
	@Test
	public void testDelete() {
		Product product = new Product();
		product.setDesribtion("description of product");
		product.setName("product name");
		productService.addProduct(product);
		productService.delete(product.getProductid());
		Product prodcutFound = productService.viewById(product.getProductid());
		assertNull("product should be deleted from database.", prodcutFound);
	}

}
