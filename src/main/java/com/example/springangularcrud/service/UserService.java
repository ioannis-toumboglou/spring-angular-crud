package com.example.springangularcrud.service;

import java.util.List;

import com.example.springangularcrud.entity.User;


public interface UserService {
	
	public List<User> findAll();
	
	public User findById(Long id);
	
	public void save(User user);
	
	public void deleteById(Long id);
	
	public void deleteAll();

}