package com.project.repository;

import org.springframework.data.repository.CrudRepository;

import com.project.model.Accounts;

public interface AccountRepository  extends CrudRepository<Accounts, Long>{

	Accounts findByUsername(String username);

}
