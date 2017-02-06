package com.project.repository;

import org.springframework.data.repository.CrudRepository;

import com.project.model.CartItem;

public interface CartItemRepository  extends CrudRepository<CartItem, Long>{

}
