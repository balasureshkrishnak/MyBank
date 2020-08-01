package com.hcl.mybank.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {
	@ExceptionHandler(AccountNotFoundException.class)
	public ResponseEntity<ErrorResponse> globalExceptionHandler(AccountNotFoundException accountNotFoundException,
			WebRequest request) {
		ErrorResponse errorResponse = new ErrorResponse();
		return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(UserNotFoundException.class)
	public ResponseEntity<ErrorResponse> globalExceptionHandler(UserNotFoundException userNotFoundException,
			WebRequest request) {
		ErrorResponse errorResponse = new ErrorResponse();
		return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
	}
	
	
}
