package com.ivogoncalves.course.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ivogoncalves.course.domain.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
