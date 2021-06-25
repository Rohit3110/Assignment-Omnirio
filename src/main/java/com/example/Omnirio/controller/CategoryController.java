package com.example.Omnirio.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CategoryController {
	
	@GetMapping("/category/123")
	ResponseEntity<String> getCategory(){
		
		ResponseEntity<String>  res= new ResponseEntity<String>("Rohit", HttpStatus.ACCEPTED);
		return res;
	}

}
