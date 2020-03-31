package com.EStore.Repositories;

import org.springframework.data.repository.CrudRepository;

import com.EStore.Entities.StoreProduct;

public interface StoreProductRepository extends CrudRepository<StoreProduct, Integer> {

}
