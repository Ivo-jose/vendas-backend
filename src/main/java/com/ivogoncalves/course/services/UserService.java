package com.ivogoncalves.course.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ivogoncalves.course.domain.User;
import com.ivogoncalves.course.repositories.UserRepository;
import com.ivogoncalves.course.services.exceptions.ObjectNotFoundException;


@Service
public class UserService {

	@Autowired
	private UserRepository repository;
	
	
	public User findById(Long id) {
		Optional<User> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("User not found! Id: " + id));
	}
	
	public List<User> findAll(){
		return repository.findAll();
	}
}
