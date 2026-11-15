package com.rafi.john.dev.otp_verification.generator;

import java.util.concurrent.ThreadLocalRandom;

import org.springframework.stereotype.Component;

@Component
public class RandomOtpGenerator implements OtpGenerator{

	@Override
	public String generateOtp() {
		// TODO Auto-generated method stub
		int otp = ThreadLocalRandom.current()
				.nextInt(100000,1000000);
		
		return String.valueOf(otp);
	}

	
}
