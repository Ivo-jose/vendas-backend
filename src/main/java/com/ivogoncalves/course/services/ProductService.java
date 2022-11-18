package com.ivogoncalves.course.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ivogoncalves.course.domain.Product;
import com.ivogoncalves.course.repositories.ProductRepository;
import com.ivogoncalves.course.services.exceptions.ObjectNotFoundException;

@Service
public class ProductService {

	@Autowired
	private ProductRepository repository;
	
	public Product findById(Long id) {
		Optional<Product> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Product not found! Id: " + id));
	}
	
	public List<Product> findAll() {
		return repository.findAll();
	}
}
