package com.project.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.project.model.Payment;

@Repository
public interface CheckoutRepository extends CrudRepository<Payment, Long>{

}
