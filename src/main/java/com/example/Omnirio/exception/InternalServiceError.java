package com.example.Omnirio.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value=HttpStatus.INTERNAL_SERVER_ERROR, reason="Error While Processing") 
public class InternalServiceError extends RuntimeException {

}
