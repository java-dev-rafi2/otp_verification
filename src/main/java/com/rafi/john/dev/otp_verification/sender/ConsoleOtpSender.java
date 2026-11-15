package com.rafi.john.dev.otp_verification.sender;

import org.springframework.stereotype.Component;

import com.rafi.john.dev.otp_verification.OtpVerificationApplication;

@Component
public class ConsoleOtpSender implements OtpSender{

    private final OtpVerificationApplication otpVerificationApplication;

    ConsoleOtpSender(OtpVerificationApplication otpVerificationApplication) {
        this.otpVerificationApplication = otpVerificationApplication;
    }

	@Override
	public void sendOtp(String mobileNumber, String otp) {
		// TODO Auto-generated method stub
		System.out.println(
				"Otp Send to the mobilenumber:"+ mobileNumber +
				" | Otp: "+otp 
				
				);
	}
}
