package com.example.Omnirio.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Omnirio.enitity.Category;
import com.example.Omnirio.repositories.CategoryRepository;

@Service
public class CategoryService {
	
	@Autowired
	CategoryRepository categoryRepository;
	
	public Optional<Category> getCategoryByID(Long id) {
		return categoryRepository.findById(id);
		
	}

}
