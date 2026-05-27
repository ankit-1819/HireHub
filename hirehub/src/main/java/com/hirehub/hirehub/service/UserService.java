package com.hirehub.hirehub.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hirehub.hirehub.entity.User;
import com.hirehub.hirehub.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	UserRepository userRepository;
	
	public User registerUser( User user) {
		
		//System.out.println(user.getEmail());
		//System.out.println(userRepository.existsByEmail(user.getEmail()));
		if(userRepository.existsByEmail(user.getEmail())) {
			
			throw new IllegalArgumentException("Email already exists");
		}
		User savedUser = userRepository.save(user);
		return savedUser;
	}
	
	public List<User> getAllUser(){
		
		return userRepository.findAll();
	}
	
	public User getUser(long id) {
		
		Optional<User> user = userRepository.findById(id);
		
		if(user.isEmpty()) {
			
			throw new IllegalArgumentException("This id not Valid");
		}
		return user.get();
	}
	
	public void deleteUser(long id) {
		
		getUser(id);
		
		userRepository.deleteById(id);
	}
	
	public User updateUser(long id,User user) {
		
		User existingUser = getUser(id);
		
		existingUser.setEmail(user.getEmail());
		existingUser.setFullName(user.getFullName());
		existingUser.setPassword(user.getPassword());
		existingUser.setRole(user.getRole());
		
		userRepository.save(existingUser);
		
		return existingUser;
		
	}
}
