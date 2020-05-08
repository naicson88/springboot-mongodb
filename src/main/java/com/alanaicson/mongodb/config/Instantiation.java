package com.alanaicson.mongodb.config;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.alanaicson.mongodb.domain.Post;
import com.alanaicson.mongodb.domain.User;
import com.alanaicson.mongodb.repository.PostRepository;
import com.alanaicson.mongodb.repository.UserRepository;

@Configuration
public class Instantiation implements CommandLineRunner {
	
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private PostRepository postRepository;
	
	@Override
	public void run(String... args) throws Exception {
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		sdf.setTimeZone(TimeZone.getTimeZone("GMT"));
		
		userRepository.deleteAll();
	
		
		User maria = new User(null, "Maria Brown", "maria@gmail.com");
		User alex = new User(null, "Alex Green", "alex@gmail.com");
		User bob = new User(null, "Bob Grey", "bob@gmail.com");
		
		Post p1 = new Post(null, sdf.parse("21/03/2018"), "Partiu viagem!", "Vou viajar para São Paulo", maria);
		Post p2 = new Post(null, sdf.parse("07/12/2019"), "Vamos jogar Xbox", "Hoje vou zerar Crackdown 3", maria);
		
		userRepository.saveAll((Arrays.asList(maria, alex, bob)));
		postRepository.saveAll(Arrays.asList(p1,p2));
		
		
	}

}
