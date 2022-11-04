package com.ivogoncalves.course.services;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ivogoncalves.course.domain.User;
import com.ivogoncalves.course.repositories.UserRepository;

@Service
public class DbService {

	@Autowired
	private UserRepository userResository;
	
	public void instanciaDb() {
		//Users
		User u1 = new User(null, "Maria Brown", "maria@gmail.com", "988888888", "123456");
		User u2 = new User(null, "Alex Green", "alex@gmail.com", "977777777", "123456");
		
		userResository.saveAll(Arrays.asList(u1,u2));
	}
}
