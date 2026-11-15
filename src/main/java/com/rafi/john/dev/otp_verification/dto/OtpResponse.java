package com.rafi.john.dev.otp_verification.dto;

public class OtpResponse {

	private String message;
	private boolean success;
	
	public OtpResponse(boolean success, String message ) {
		this.success = success;
		this.message = message;
	}
	
	public void setMessage(String message) {
		this.message = message;
	}
	
	public String getMessage() {
		return message;
	}
	
	public void setSuccess(boolean success) {
		this.success = success;
	}
	
	public boolean getSuccess() {
		return success;
	}
}
