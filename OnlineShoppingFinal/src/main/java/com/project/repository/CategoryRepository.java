package com.project.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.project.model.Category;

@Repository
public interface CategoryRepository extends CrudRepository<Category, Long>{

}
