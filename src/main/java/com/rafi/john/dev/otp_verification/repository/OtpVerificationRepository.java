package com.rafi.john.dev.otp_verification.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rafi.john.dev.otp_verification.entity.OtpVerification;


public interface OtpVerificationRepository extends JpaRepository<OtpVerification, Long>{

	Optional<OtpVerification> findTopByMobileNumberOrderByCreatedAtDesc(String mobileNumber);
	
	
}
