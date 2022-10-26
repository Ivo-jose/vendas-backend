package com.ivogoncalves.course.resources;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ivogoncalves.course.domain.User;

@RestController
@RequestMapping(value = "/users")
public class UserResource {
	
//	@GetMapping(path = "/{id}")
//	public ResponseEntity<User> findById(@PathVariable Integer id){
//		
//	}
	
	@GetMapping
	public ResponseEntity<User> findAll(){
		User obj = new User(1L, "André Silva", "andre@gmail.com", "9977-45-987", "#%&*(!%");
		return ResponseEntity.ok().body(obj);
	}
}
