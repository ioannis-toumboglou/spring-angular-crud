package com.example.springangularcrud.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.springangularcrud.dao.UserRepository;
import com.example.springangularcrud.entity.User;

@Service
public class UserServiceImpl implements UserService {

	private UserRepository userRepository;
	
	@Autowired
	public UserServiceImpl(UserRepository theUserRepository) {
		userRepository = theUserRepository;
	}
	
	@Override
	public List<User> findAll() {
		return userRepository.findAllByOrderByNameAsc();
	}

	@Override
	public User findById(Long id) {
		Optional<User> result = userRepository.findById(id);
		
		User user = null;
		// Check if the movie exists
		if (result.isPresent()) {
			user = result.get();
		} else {
			throw new RuntimeException("Unable to find the user id - " + id);
		}
		
		return user;
	}

	@Override
	public void save(User user) {
		userRepository.save(user);
	}

	@Override
	public void deleteById(Long id) {		
		userRepository.deleteById(id);
	}

	@Override
	public void deleteAll() {
		userRepository.deleteAll();
	}

}
