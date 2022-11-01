package com.ivogoncalves.course.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ivogoncalves.course.domain.User;

public interface UserRepository extends JpaRepository<User, Long>{
}
