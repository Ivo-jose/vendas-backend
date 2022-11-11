package com.ivogoncalves.course.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ivogoncalves.course.domain.Order;
import com.ivogoncalves.course.repositories.OrderRepository;
import com.ivogoncalves.course.services.exceptions.ObjectNotFoundException;

@Service
public class OrderService {

	@Autowired
	private OrderRepository repository;
	
	public Order findById(Long id) {
		Optional<Order> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Order not found! Id: " + id));
	}
	
	public List<Order> findAll(){
		return repository.findAll();
	}
}
