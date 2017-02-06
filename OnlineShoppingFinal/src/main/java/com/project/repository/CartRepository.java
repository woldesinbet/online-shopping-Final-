package com.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.project.model.Cart;

public interface CartRepository extends JpaRepository<Cart, Long> {
//	C.status = com.project.model.CartStatus.NEW AND 
	@Query("SELECT C FROM Cart C WHERE C.status = 'NEW' AND C.account.username = :username")
	public Cart findNewCartOfCutomer(@Param("username") String username);
}
