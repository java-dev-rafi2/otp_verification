package com.rafi.john.dev.otp_verification.dto;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class OtpResponse {

	private String message;
	private boolean success;
	private String otp;

	public OtpResponse(boolean success, String message) {
		this.success = success;
		this.message = message;
	}

	public OtpResponse(boolean success, String message, String otp) {
		this.success = success;
		this.message = message;
		this.otp = otp;
	}

	public String getOtp() {
		return otp;
	}

	public void setOtp(String otp) {
		this.otp = otp;
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
