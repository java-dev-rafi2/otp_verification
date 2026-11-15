package com.rafi.john.dev.otp_verification.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rafi.john.dev.otp_verification.dto.OtpResponse;
import com.rafi.john.dev.otp_verification.dto.SendOtpRequest;
import com.rafi.john.dev.otp_verification.dto.VerifyOtp;
import com.rafi.john.dev.otp_verification.entity.OtpVerification;
import com.rafi.john.dev.otp_verification.service.OtpService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/otp")
public class OtpController {
	
	private final OtpService otpService;
	
	public OtpController(OtpService otpService) {
		// TODO Auto-generated constructor stub
		this.otpService = otpService;
	}

	@PostMapping("/send")
	public ResponseEntity<OtpResponse> sendOtp(@Valid @RequestBody SendOtpRequest request){
		OtpResponse response = otpService.sendOtp(request);
		 return ResponseEntity.ok(response);			
	}
	@PostMapping("/verify")
	public ResponseEntity<OtpResponse> verifyOtp(@Valid @RequestBody VerifyOtp request){
		OtpResponse response = otpService.verifyOtp(request); 
		return ResponseEntity.ok(response);
		
	}
}
