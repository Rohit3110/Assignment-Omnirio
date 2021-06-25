package com.example.Omnirio.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.Omnirio.enitity.Category;
import com.example.Omnirio.exception.ResourceNotFoundException;
import com.example.Omnirio.service.CategoryService;

@RestController
public class CategoryController {
	
	@Autowired
	CategoryService catService;
	
	//@CrossOrigin(origins = "http://localhost:9090")
	@GetMapping("/category/{id}")
	
	Category getCategory(@PathVariable Long id) {
		
		Optional<Category> cat = catService.getCategoryByID(id);
		
		
		
		if(!cat.isPresent()) {
			throw new ResourceNotFoundException(id);
			//throw new InternalServiceError();
		}else
		{
			
			
			return cat.get();
		}
			
	}

}
