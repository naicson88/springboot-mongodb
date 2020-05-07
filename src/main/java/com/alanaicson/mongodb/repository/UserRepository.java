package com.alanaicson.mongodb.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.alanaicson.mongodb.domain.User;

@Repository
public interface UserRepository extends MongoRepository<User, String> {

	
	
}
