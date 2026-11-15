package com.rafi.john.dev.otp_verification.service.impl;

import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.rafi.john.dev.otp_verification.OtpVerificationApplication;
import com.rafi.john.dev.otp_verification.dto.OtpResponse;
import com.rafi.john.dev.otp_verification.dto.SendOtpRequest;
import com.rafi.john.dev.otp_verification.dto.VerifyOtp;
import com.rafi.john.dev.otp_verification.entity.OtpVerification;
import com.rafi.john.dev.otp_verification.exception.OtpNotFoundException;
import com.rafi.john.dev.otp_verification.generator.OtpGenerator;
import com.rafi.john.dev.otp_verification.repository.OtpVerificationRepository;
import com.rafi.john.dev.otp_verification.sender.OtpSender;
import com.rafi.john.dev.otp_verification.service.OtpService;

@Service
public class OtpServiceImpl implements OtpService {

    private final OtpVerificationApplication otpVerificationApplication;

	private final OtpGenerator otpGenerator;

	private final OtpSender otpSender;

	private final OtpVerificationRepository otpVerificationRepository;

	@Override
	public OtpResponse sendOtp(SendOtpRequest request) {
		// TODO Auto-generated method stub
		String otp = otpGenerator.generateOtp();

		OtpVerification otpVerification = new OtpVerification();

		otpVerification.setMobileNumber(request.getMobileNumber());

		otpVerification.setOtp(otp);

		LocalDateTime now = LocalDateTime.now();
		otpVerification.setCreatedAt(now);

		otpVerification.setExpiresAt(now.plusMinutes(5));

		otpVerification.setVerified(false);

		otpVerification.setAttempts(0);

		otpVerificationRepository.save(otpVerification);

		otpSender.sendOtp(request.getMobileNumber(), otp);
		return new OtpResponse(true, "Otp Sent Successfully");
	}

	@Override
	public OtpResponse verifyOtp(VerifyOtp request) {
		// TODO Auto-generated method stub
		Optional<OtpVerification> otpOptional = 
				otpVerificationRepository.findTopByMobileNumberOrderByCreatedAtDesc(request.getMobileNumber());
		if(otpOptional.isEmpty()) {
//			return new OtpResponse(
//					false, "No OTP found on this Number");
			throw new OtpNotFoundException("No OTP found on this Number");
		}
		
		OtpVerification otpVerification = otpOptional.get();
		otpVerification.getOtp();
		otpVerification.getExpiresAt();
		otpVerification.getAttempts();
		
		if(otpVerification.getVerified()) {
			return new OtpResponse(false,"OTP already verified");
		}
		
		
		System.out.println(
		        "Current time: " + LocalDateTime.now()
		);

		System.out.println(
		        "Expiry time: " + otpVerification.getExpiresAt()
		);
		
		
		if(LocalDateTime.now().isAfter(otpVerification.getExpiresAt())) {
			return new OtpResponse(
					false,"OTP has Expired");
		}
		
		
		if(otpVerification.getAttempts()>= 5) {
			return new OtpResponse(
					false,"Exceed Max OTPs");
		}
		if(!otpVerification.getOtp().equals(request.getOtp())) {
			otpVerification.setAttempts(otpVerification.getAttempts()+1);
			
			otpVerificationRepository.save(otpVerification);
			
			return new OtpResponse(
					false,"Invalid OTP");
		}
		
		otpVerification.setVerified(true);
		otpVerificationRepository.save(otpVerification);
		return new OtpResponse(true, "OTP verified Successfully...!");
	}

	public OtpServiceImpl(OtpGenerator otpGenerator, OtpSender otpSender,
			OtpVerificationRepository otpVerificationRepository, OtpVerificationApplication otpVerificationApplication) {
		// TODO Auto-generated constructor stub
		this.otpGenerator = otpGenerator;
		this.otpSender = otpSender;
		this.otpVerificationRepository = otpVerificationRepository;
		this.otpVerificationApplication = otpVerificationApplication;

	}
}
