package com.example.Omnirio.controller;

import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.Omnirio.enitity.Attribute;
import com.example.Omnirio.enitity.Category;
import com.example.Omnirio.exception.ResourceNotFoundException;
import com.example.Omnirio.repositories.AttribueRepository;
import com.example.Omnirio.repositories.CategoryRepository;
import com.example.Omnirio.service.CategoryService;

@RestController
public class CategoryController {

	@Autowired
	CategoryService catService;

	@Autowired
	CategoryRepository categoryRepository;
	
	@Autowired
	AttribueRepository attRepository;

	// @CrossOrigin(origins = "http://localhost:9090")
	@GetMapping(path="/category/{id}" , consumes = "application/json", produces = "application/json")

	Category getCategory(@PathVariable Long id) {

		Optional<Category> cat = catService.getCategoryByID(id);

		if (!cat.isPresent()) {
			throw new ResourceNotFoundException(id);
			// throw new InternalServiceError();
		} else {

			return cat.get();
		}

	}

	@PutMapping(path ="/category/{id}", consumes = "application/json", produces = "application/json")

	Category updateCategory(@RequestBody Category newCategory, @PathVariable Long id) {
		
		Set<Attribute> set = newCategory.getCategoryAttribute();
		for(Attribute att: set) {
			
			if(!attRepository.existsById(att.getId())) {
				Attribute at= new Attribute();
				at=att;
				attRepository.save(at);
				
			}
			
		}
		

		return catService.getCategoryByID(id).map(cat -> {
			cat.setCategoryAttribute(newCategory.getCategoryAttribute());
			return categoryRepository.save(cat);
		}).orElseGet(() -> {

			return categoryRepository.save(newCategory);
		});

	}

}
