package com.project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.model.Category;
import com.project.repository.CategoryRepository;

@Service
public class CategoryService {

	@Autowired
	CategoryRepository categoryRepository;

	public void addCategory(Category category) {
		categoryRepository.save(category);
	}

	public List<Category> viewCategory() {
		return (List<Category>) categoryRepository.findAll();
	}

	public void delete(long id) {
		categoryRepository.delete(id);
	}

	public Category viewById(long id) {
		return categoryRepository.findOne(id);
	}

}
