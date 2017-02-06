package com.project.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.project.model.Product;

@Repository
public interface ProductRepository extends CrudRepository<Product, Long> {
	@Query("SELECT p FROM Product p WHERE p.quantitiy > 0")
	List<Product> findAllNotFinished();

}
