package com.example.cricketseatbooking.repository;

import org.springframework.data.repository.CrudRepository;

import com.example.cricketseatbooking.entities.User;

public interface UserRepository extends CrudRepository<User, Long> {

}
