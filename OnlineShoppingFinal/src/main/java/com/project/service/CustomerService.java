package com.project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.model.Customer;
import com.project.repository.CustomerRepository;

@Service
public class CustomerService {
	@Autowired
	CustomerRepository customerRepository;

	public void addCustomer(Customer customer) {
		customerRepository.save(customer);

	}

	public List<Customer> viewCustomer() {
		return (List<Customer>) customerRepository.findAll();
	}

	public void delete(long id) {
		customerRepository.delete(id);
	}

	public Customer viewById(long id) {
		return customerRepository.findOne(id);
	}

}
