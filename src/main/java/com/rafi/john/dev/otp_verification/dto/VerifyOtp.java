package com.rafi.john.dev.otp_verification.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public class VerifyOtp {

	@NotBlank(message = "mobile number is mandatory")
	@Pattern(regexp = "^[0-9]{10}$", message = "must contain exactly 10 digits")
	private String mobileNumber;

	@NotBlank(message = "Please enter valid OTP")
	@Pattern(regexp = "^[0-9]{6}$", message = "OTP must be 6 digit")
	private String otp;

	public VerifyOtp() {
		// TODO Auto-generated constructor stub
	}

	public void setOtp(String otp) {
		this.otp = otp;
	}

	public String getOtp() {
		return otp;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}
}
