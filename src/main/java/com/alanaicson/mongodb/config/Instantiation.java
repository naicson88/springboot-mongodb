package com.alanaicson.mongodb.config;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.alanaicson.mongodb.domain.Post;
import com.alanaicson.mongodb.domain.User;
import com.alanaicson.mongodb.dto.AuthorDTO;
import com.alanaicson.mongodb.dto.CommentDTO;
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
		
		userRepository.saveAll((Arrays.asList(maria, alex, bob)));
		
		Post p1 = new Post(null, sdf.parse("21/03/2018"), "Partiu viagem!", "Vou viajar para São Paulo", new AuthorDTO(maria));
		Post p2 = new Post(null, sdf.parse("07/12/2019"), "Vamos jogar Xbox", "Hoje vou zerar Crackdown 3", new AuthorDTO(maria));
		
		CommentDTO c1 = new CommentDTO("Boa viagem, mano", sdf.parse("23/01/2018"), new AuthorDTO(alex));
		CommentDTO c2 = new CommentDTO("Tenha um ótimo dia", sdf.parse("07/05/2019"), new AuthorDTO(maria));
		
		p1.getComments().addAll(Arrays.asList(c1));
		p1.getComments().addAll(Arrays.asList(c2));
		
		postRepository.saveAll(Arrays.asList(p1,p2));
		
		maria.getPosts().addAll(Arrays.asList(p1, p2));
		userRepository.save(maria);
		
		
	}

}
