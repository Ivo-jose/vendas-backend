package com.ivogoncalves.course.services;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ivogoncalves.course.domain.Order;
import com.ivogoncalves.course.domain.User;
import com.ivogoncalves.course.domain.enums.OrderStatus;
import com.ivogoncalves.course.repositories.OrderRepository;
import com.ivogoncalves.course.repositories.UserRepository;

@Service
public class DbService {

	@Autowired
	private UserRepository userRepository;
	@Autowired
	private OrderRepository orderRepository;
	
	public void instanciaDb() {
		//Users
		User u1 = new User(null, "Maria Brown", "maria@gmail.com", "988888888", "123456");
		User u2 = new User(null, "Alex Green", "alex@gmail.com", "977777777", "123456");
		
		userRepository.saveAll(Arrays.asList(u1,u2));
		
		//Orders
		Order o1 = new Order(null, Instant.parse("2019-06-20T19:53:07Z"), OrderStatus.PAID ,u1);
		Order o2 = new Order(null, Instant.parse("2019-07-21T03:42:10Z"), OrderStatus.WAIT_PAYMENT, u2);
		Order o3 = new Order(null, Instant.parse("2019-07-22T15:21:22Z"), OrderStatus.WAIT_PAYMENT,u1);
		
		orderRepository.saveAll(Arrays.asList(o1,o2,o3));
		
		
	}
}
