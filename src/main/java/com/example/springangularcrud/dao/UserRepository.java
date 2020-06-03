package com.example.springangularcrud.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.springangularcrud.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
	
	User findByName(String name);

}