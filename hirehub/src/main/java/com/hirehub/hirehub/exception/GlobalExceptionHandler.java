package com.hirehub.hirehub.exception;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class GlobalExceptionHandler {

	
	@ExceptionHandler(IllegalArgumentException.class)
	public ResponseEntity<Map<String,String>> duplicateRegisteration(IllegalArgumentException ex) {
		
		Map<String,String> map = new HashMap<>();
		
		map.put("message", ex.getMessage());
		
		
		return ResponseEntity.badRequest().body(map);
		
	}
		
}
