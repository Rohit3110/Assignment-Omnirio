package com.example.Omnirio.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Omnirio.enitity.Attribute;
import com.example.Omnirio.repositories.AttribueRepository;

@Service
public class AttributeService {
	
	@Autowired
	AttribueRepository repo;
	
	public Optional<Attribute> getAttributeById(Long id){
		return repo.findById(id);
	}

}
