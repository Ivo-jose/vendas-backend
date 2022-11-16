package com.ivogoncalves.course.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ivogoncalves.course.domain.Category;
import com.ivogoncalves.course.repositories.CategoryRepository;
import com.ivogoncalves.course.services.exceptions.ObjectNotFoundException;

@Service
public class CategoryService {

	@Autowired
	private CategoryRepository repository;
	
	public Category findById(Long id) {
		Optional<Category> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Object not found! Id?: " + id) );
	}
	
	public List<Category> findAll() {
		return repository.findAll();
	}
}
