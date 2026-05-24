package com.hirehub.hirehub.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hirehub.hirehub.entity.User;
import com.hirehub.hirehub.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	UserRepository userRepository;
	
	public User addUser(User user) {
		
		User savedUser = userRepository.save(user);
		return savedUser;
	}
}
