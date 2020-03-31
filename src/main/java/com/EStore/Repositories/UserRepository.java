package com.EStore.Repositories;

import org.springframework.data.repository.CrudRepository;

import com.EStore.Entities.user;

public interface UserRepository extends CrudRepository<user, Integer> {

}
