package com.example.Omnirio.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ctc.wstx.shaded.msv_core.verifier.regexp.AttributeRemover;
import com.example.Omnirio.enitity.Attribute;
import com.example.Omnirio.exception.ResourceNotFoundException;
import com.example.Omnirio.repositories.AttribueRepository;
import com.example.Omnirio.service.AttributeService;

@RestController
public class AttributeController {

	@Autowired
	AttributeService attributeService;
	
	@Autowired
	AttribueRepository repo;

	@GetMapping(path="/attribute/{id}", consumes = "application/json", produces = "application/json")
		
	Attribute getAttribute(@PathVariable Long id) {

		Optional<Attribute> att = attributeService.getAttributeById(id);

		if (!att.isPresent()) {
			throw new ResourceNotFoundException(id);
			// throw new InternalServiceError();
		} else {

			return att.get();
		}

	}
	
	@PostMapping(path="/attribute", consumes = "application/json", produces = "application/json")
	Attribute getAttribute(@RequestBody Attribute attribute) {

		Attribute att = repo.save(attribute);

		

			return att;
		}

	

}
