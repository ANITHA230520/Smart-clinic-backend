package com.app.hospital.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class AdminDTO {

	private int adminId;

	@NotBlank(message = "The AdminName not be blank")
	@Size(min = 3, max = 100)
	private String adminName;

	private Long phoneNumber;

	@NotBlank(message = "The email should not be blank empty or null")
	@Email(message = "Please enter  the valid EmailId", regexp = "^[a-zA-Z0-9.-]+@[a-zA-Z0-9]+\\.[a-zA-Z.]{2,5}")
	private String emailId;

	@NotBlank(message = "The Password  Should not be blank")
	@Size(min = 5, max = 15)

	private String password;

	public int getAdminId() {
		return adminId;
	}

	public void setAdminId(int adminId) {
		this.adminId = adminId;
	}

	public String getAdminName() {
		return adminName;
	}

	public void setAdminName(String adminName) {
		this.adminName = adminName;
	}

	public Long getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(Long phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
