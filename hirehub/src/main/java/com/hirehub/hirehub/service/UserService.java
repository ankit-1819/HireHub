package com.hirehub.hirehub.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.hirehub.hirehub.entity.User;
import com.hirehub.hirehub.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	UserRepository userRepository;
	
	public User addUser( User user) {
		
		//System.out.println(user.getEmail());
		//System.out.println(userRepository.existsByEmail(user.getEmail()));
		if(userRepository.existsByEmail(user.getEmail())) {
			
			throw new IllegalArgumentException("Email already exists");
		}
		User savedUser = userRepository.save(user);
		return savedUser;
	}
}
