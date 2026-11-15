package com.rafi.john.dev.otp_verification.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(OtpNotFoundException.class)
	public ResponseEntity<ErrorResponse> handleOtpNotFound(
		OtpNotFoundException exception){
			ErrorResponse errorResponse = 
					new ErrorResponse(exception.getMessage(), false);
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorResponse);
	}
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<ErrorResponse> handleValidation(
			MethodArgumentNotValidException exception){
		String errorMessage = exception.getBindingResult()
				.getFieldError()
				.getDefaultMessage();
		
		ErrorResponse errorResponse = new ErrorResponse(errorMessage, false);
		
		return ResponseEntity.status(HttpStatus.BAD_REQUEST)
				.body(errorResponse);
	}
	
}
