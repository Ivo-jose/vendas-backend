package com.ivogoncalves.course.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ivogoncalves.course.domain.Order;

public interface OrderRepository extends JpaRepository<Order, Long>{
}
