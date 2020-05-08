package com.alanaicson.mongodb.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.alanaicson.mongodb.domain.Post;

@Repository
public interface PostRepository extends MongoRepository<Post, String> {
	
}
