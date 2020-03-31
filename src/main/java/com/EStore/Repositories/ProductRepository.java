package com.EStore.Repositories;

import org.springframework.data.repository.CrudRepository;

import com.EStore.Entities.Product;

public interface ProductRepository extends CrudRepository<Product, Integer> {
	
	
}
