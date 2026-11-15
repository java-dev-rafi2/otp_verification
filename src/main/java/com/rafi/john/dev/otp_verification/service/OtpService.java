package com.rafi.john.dev.otp_verification.service;

import com.rafi.john.dev.otp_verification.dto.OtpResponse;
import com.rafi.john.dev.otp_verification.dto.SendOtpRequest;
import com.rafi.john.dev.otp_verification.dto.VerifyOtp;

public interface OtpService {

	OtpResponse sendOtp(SendOtpRequest request);
	
	OtpResponse verifyOtp(VerifyOtp request);
}
