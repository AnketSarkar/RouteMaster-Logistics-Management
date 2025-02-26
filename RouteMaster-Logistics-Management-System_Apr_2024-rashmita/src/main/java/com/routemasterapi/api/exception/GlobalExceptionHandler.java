package com.routemasterapi.api.exception;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

	
	@ExceptionHandler(NullPointerException.class)
    public ResponseEntity<String> handleNullPointerException(NullPointerException ex) {
        return new ResponseEntity<>("NullPointerException occurred: " + ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }
	
	@ExceptionHandler(EmptyResultDataAccessException.class)
	public ResponseEntity<String> handleEmptyResultDataAccessException(EmptyResultDataAccessException ex){
		return new ResponseEntity<>("EmptyResultDataAccessException occurred: " + ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		
	}
}
