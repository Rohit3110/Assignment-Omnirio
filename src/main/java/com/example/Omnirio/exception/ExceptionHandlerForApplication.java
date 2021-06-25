package com.example.Omnirio.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class ExceptionHandlerForApplication {
	
	  Logger log = LoggerFactory.getLogger(ExceptionHandlerForApplication.class);
	  @ResponseBody
	  @ExceptionHandler(ResourceNotFoundException.class)
	  @ResponseStatus(HttpStatus.NOT_FOUND)
	  String ResourceNotFoundExceptionHandler(ResourceNotFoundException ex) {
		log.error("error while finding the resource",ex.getStackTrace());
	    return ex.getMessage();
	  }
	  
	  
	
}



 
