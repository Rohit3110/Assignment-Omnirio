package com.example.Omnirio.exception;

public class ResourceNotFoundException extends RuntimeException {

	public ResourceNotFoundException(Long id) {
	    super("Could not find resource with Id " + id);
	  }
	}