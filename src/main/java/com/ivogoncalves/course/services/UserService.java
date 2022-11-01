package com.ivogoncalves.course.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.ivogoncalves.course.domain.User;
import com.ivogoncalves.course.repositories.UserRepository;

public class UserService {

	@Autowired
	private UserRepository repository;
	
	public List<User> findAll(){
		return repository.findAll();
	}
}
