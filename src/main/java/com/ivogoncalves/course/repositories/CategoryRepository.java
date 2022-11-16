package com.ivogoncalves.course.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ivogoncalves.course.domain.Category;

public interface CategoryRepository extends JpaRepository<Category, Long>{
}
