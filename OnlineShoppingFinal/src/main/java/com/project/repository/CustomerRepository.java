package com.project.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.project.model.Customer;

@Repository
public interface CustomerRepository extends CrudRepository<Customer, Long> {
	Customer findByAccountUsername(String username);
}
