package com.project.service;

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

import com.project.model.Category;

@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("test")
public class CategoryServiceTest {
	@Autowired
	CategoryService categoryService;

	@Test
	public void testAddCategory() {
		Category category = new Category();
		category.setDescription("description of category");
		category.setName("category name");
		categoryService.addCategory(category);
		assertTrue("Category should be saved to database..", category.getId() > 0);
	}

	@Test
	public void testViewById() {
		Category category = new Category();
		category.setDescription("description of category");
		category.setName("category name");
		categoryService.addCategory(category);
		Category categoryFound = categoryService.viewById(category.getId());
		assertEquals("Category should be found.", categoryFound.getId(), category.getId());
	}

	@Test
	public void testViewCategory() {
		Category category = new Category();
		category.setDescription("description of category");
		categoryService.addCategory(category);
		List<Category> categories = (List<Category>) categoryService.viewCategory();
		assertTrue("Returned list must not be empty", !categories.isEmpty());
	}

	@Test
	public void testDelete() {
		Category category = new Category();
		category.setDescription("description of category");
		category.setName("category name");
		categoryService.addCategory(category);
		categoryService.delete(category.getId());
		Category categoryFound = categoryService.viewById(category.getId());
		assertNull("Category should be deleted from database.", categoryFound);
	}

}
