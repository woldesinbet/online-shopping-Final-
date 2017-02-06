package com.project.repository;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

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

/*@DataJpaTest
@AutoConfigureTestDatabase(connection = EmbeddedDatabaseConnection.H2)
*/public class CategoryRepositoryTest {

	@Autowired
	CategoryRepository categoryRepository;

	@Test
	public void testSave() {
		Category category = new Category();
		category.setDescription("description of category");
		category.setName("category name");
		categoryRepository.save(category);
		assertTrue("Category should be saved to database..", category.getId() > 0);
	}

	@Test
	public void testFindeOne() {
		Category category = new Category();
		category.setDescription("description of category");
		category.setName("category name");
		categoryRepository.save(category);
		Category categoryFound = categoryRepository.findOne(category.getId());
		assertEquals("Category should be found.", categoryFound.getId(), category.getId());
	}

	@Test
	public void testFindAll() {
		Category category = new Category();
		category.setDescription("description of category");
		categoryRepository.save(category);
		List<Category> categories = (List<Category>) categoryRepository.findAll();
		assertTrue("Returned list must not be empty",!categories.isEmpty());
	}

	@Test
	public void testDelete() {
		Category category = new Category();
		category.setDescription("description of category");
		category.setName("category name");
		categoryRepository.save(category);
		categoryRepository.delete(category.getId());
		Category categoryFound = categoryRepository.findOne(category.getId());
		assertNull("Category should be deleted from database.", categoryFound);
	}
}
