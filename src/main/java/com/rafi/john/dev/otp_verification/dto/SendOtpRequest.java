package com.rafi.john.dev.otp_verification.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public class SendOtpRequest {

	@NotBlank(message = "mobile number is required")
	@Pattern(regexp = "^[0-9]{10}$", message = "mobile number must contain exactly 10 digits")
	private String mobileNumber;

	public SendOtpRequest() {
		// TODO Auto-generated constructor stub
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

}
