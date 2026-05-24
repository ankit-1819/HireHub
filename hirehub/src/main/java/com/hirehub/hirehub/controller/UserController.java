package com.hirehub.hirehub.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hirehub.hirehub.entity.User;
import com.hirehub.hirehub.service.UserService;

@RestController
@RequestMapping("/hirehub")
public class UserController {
	
	@Autowired
	UserService userService;
	
	@PostMapping("/register")
	public ResponseEntity<User> addUser(@RequestBody User user){
		
		User newUser = userService.addUser(user);
		
		return ResponseEntity.ok(newUser);
				
	}
}
