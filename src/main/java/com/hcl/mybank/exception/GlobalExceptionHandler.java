package com.hcl.mybank.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(FromAccountNotFoundException.class)
	public ResponseEntity<ErrorResponse> globalExceptionHandler(FromAccountNotFoundException fromAccountNotFoundException,
			WebRequest request) {
		ErrorResponse errorResponse = new ErrorResponse(fromAccountNotFoundException.getMessage(),
				HttpStatus.NOT_FOUND.value(), request.getDescription(false));
		return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(ToAccountNotFoundException.class)
	public ResponseEntity<ErrorResponse> globalExceptionHandler(ToAccountNotFoundException toAccountNotFoundException,
			WebRequest request) {
		ErrorResponse errorResponse = new ErrorResponse(toAccountNotFoundException.getMessage(),
				HttpStatus.NOT_FOUND.value(), request.getDescription(false));
		return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(InsufficientBalanceException.class)
	public ResponseEntity<ErrorResponse> globalExceptionHandler(InsufficientBalanceException insufficientBalanceException,
			WebRequest request) {
		ErrorResponse errorResponse = new ErrorResponse(insufficientBalanceException.getMessage(),
				HttpStatus.NOT_FOUND.value(), request.getDescription(false));
		return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(DayLimitReachedException.class)
	public ResponseEntity<ErrorResponse> globalExceptionHandler(DayLimitReachedException dayLimitReachedException,
			WebRequest request) {
		ErrorResponse errorResponse = new ErrorResponse(dayLimitReachedException.getMessage(),
				HttpStatus.NOT_FOUND.value(), request.getDescription(false));
		return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(NullPointerException.class)
	public ResponseEntity<ErrorResponse> globalExceptionHandler(NullPointerException nullPointerException,
			WebRequest request) {
		ErrorResponse errorResponse = new ErrorResponse(nullPointerException.getMessage(), HttpStatus.NOT_FOUND.value(),
				request.getDescription(false));
		return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
	}

}
