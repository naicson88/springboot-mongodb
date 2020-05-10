package com.alanaicson.mongodb.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alanaicson.mongodb.domain.Post;
import com.alanaicson.mongodb.repository.PostRepository;
import com.alanaicson.mongodb.service.exception.ObjectNotFoundExcepction;

@Service
public class PostService {
	
	@Autowired
	private PostRepository repo;
	
	
	public Post findById(String id) {
		Optional<Post> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundExcepction("Objeto não encontrado"));

	}
	
	public List<Post> findByTitle(String txt){
		return repo.searchTitle(txt);
	}
	
}
