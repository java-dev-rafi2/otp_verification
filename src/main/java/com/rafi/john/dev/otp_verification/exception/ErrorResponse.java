package com.rafi.john.dev.otp_verification.exception;

public class ErrorResponse {

	private boolean success;
	private String message;

	public ErrorResponse(String message, boolean success) {
		// TODO Auto-generated constructor stub
		this.message = message;
		this.success = success;
	}
	
	public boolean isSuccess() {
		return success;
	}
	
	public String getMessage() {
		return message;
	}
}
