package com.app.hospital.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class PatientDTO {

	// validation for all attributes
    private int patientId;
	@NotBlank(message = "The Patient name should not be blank")
	@Size(min = 3, max = 100)
	private String patientName;

	@Min(value = 1, message = "Age should not be less than 1")
	@Max(value = 100, message = "Age should not be greater  than 100")
	private int patientAge;

	@NotNull
	private String bloodGroup;

	@Min(value = 0, message = "height should not be 0 feet")
	@Max(value = 9, message = "height should not be greater  than 9 feet")
	private int height;

	@Min(value = 0, message = "Weight should not be 0kg")
	@Max(value = 500, message = "Weight should not be greater  than 500 kg ")
	private int weight;

	@NotBlank(message = "The gender  should not be blank")
	private String gender;

	@NotNull
	private Long phoneNo;

	@NotBlank(message = "The city should not be blank")
	@Size(min = 3, max = 100)
	private String city;

	@NotBlank(message = "The email should not be blank or empty or Null")
	@Email(message = "Please enter a valid email id", regexp = "^[a-zA-Z0-9._-]+@[a-zA-Z0-9]+\\.[a-zA-Z.]{2,5}")
	private String email;

	@NotBlank(message = "The password field should not be blank")
	@Size(min = 5, max = 15)
	private String password;

	@NotNull
	private int temperature;
	

	public int getPatientId() {
		return patientId;
	}

	public void setPatientId(int patientId) {
		this.patientId = patientId;
	}

	public String getPatientName() {
		return patientName;
	}

	public void setPatientName(String patientName) {
		this.patientName = patientName;
	}

	public int getPatientAge() {
		return patientAge;
	}

	public void setPatientAge(int patientAge) {
		this.patientAge = patientAge;
	}

	public String getBloodGroup() {
		return bloodGroup;
	}

	public void setBloodGroup(String bloodGroup) {
		this.bloodGroup = bloodGroup;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Long getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(Long phoneNo) {
		this.phoneNo = phoneNo;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getTemperature() {
		return temperature;
	}

	public void setTemperature(int temperature) {
		this.temperature = temperature;
	}

}
