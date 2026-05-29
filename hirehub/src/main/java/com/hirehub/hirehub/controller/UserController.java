package com.hirehub.hirehub.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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
	public ResponseEntity<User> registerUser(@RequestBody User user){
		
		User newUser = userService.registerUser(user);
		
		return ResponseEntity.ok(newUser);
				
	}
	
	@GetMapping("/users")
	public ResponseEntity<List<User>> getAllUser(){
		
		List<User> userList = userService.getAllUser();
		
		return ResponseEntity.ok(userList);
		
	}
	
	@GetMapping("/user/{id}")
	public ResponseEntity<User> getUser(@PathVariable int id){
		
		return ResponseEntity.ok(userService.getUser(id));
	}
	
	@DeleteMapping("/delete/{id}")
	public String deleteUser(@PathVariable long id){
		
		userService.deleteUser(id);
		
		return "User deleted successfully";
	}
	
	@PutMapping("/user/update/{id}")
	public ResponseEntity<User> updateUser(@PathVariable long id,@RequestBody User user){
		
		return ResponseEntity.ok(userService.updateUser(id,user));
	}
	
	@PostMapping("/user/login")
	public ResponseEntity<User> loginUser(@RequestBody User user){
			
		return ResponseEntity.ok(userService.loginUser(user));
	}
}
