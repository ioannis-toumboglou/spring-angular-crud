package com.example.springangularcrud.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.springangularcrud.entity.User;

public interface UserRepository extends JpaRepository<User, Integer> {
	
	// Add a method to sort records by last name
	public List<User> findAllByOrderByNameAsc();

}