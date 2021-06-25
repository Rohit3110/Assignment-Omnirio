package com.example.Omnirio.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.Omnirio.enitity.Attribute;
import com.example.Omnirio.exception.ResourceNotFoundException;
import com.example.Omnirio.service.AttributeService;

@RestController
public class AttributeController {

	@Autowired
	AttributeService attributeService;

	@GetMapping("/attribute/{id}")
	Attribute getAttribute(@PathVariable Long id) {

		Optional<Attribute> att = attributeService.getAttributeById(id);

		if (!att.isPresent()) {
			throw new ResourceNotFoundException(id);
			// throw new InternalServiceError();
		} else {

			return att.get();
		}

	}

}
