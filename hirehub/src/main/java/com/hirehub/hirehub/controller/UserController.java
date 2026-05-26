package com.hirehub.hirehub.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
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
	
	@GetMapping("/users")
	public ResponseEntity<List<User>> getAllUser(){
		
		List<User> userList = userService.getAllUser();
		
		return ResponseEntity.ok(userList);
		
	}
}
