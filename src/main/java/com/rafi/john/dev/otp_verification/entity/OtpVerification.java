package com.rafi.john.dev.otp_verification.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "otp_verification")
public class OtpVerification {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@Column
	private String mobileNumber;
	@Column
	private String otp;
	@Column
	private LocalDateTime createdAt;
	@Column
	private LocalDateTime expiresAt;
	@Column
	private boolean verified;
	@Column
	private int attempts;

	public OtpVerification() {
		// TODO Auto-generated constructor stub
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getId() {
		return id;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setOtp(String otp) {
		this.otp = otp;
	}

	public String getOtp() {
		return otp;
	}

	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}
	
	public LocalDateTime getCreatedAt() {
		return createdAt;
	}
	
	public void setExpiresAt(LocalDateTime expiresAt) {
		this.expiresAt = expiresAt;
	}
	
	public LocalDateTime getExpiresAt() {
		return expiresAt;
	}
	
	public boolean getVerified() {
		return verified;
	}
	
	public void setVerified(boolean verified) {
		this.verified = verified;
	}
	
	public void setAttempts(int attempts) {
		this.attempts = attempts;
	}
	
	public int getAttempts() {
		return attempts;
	}
}
