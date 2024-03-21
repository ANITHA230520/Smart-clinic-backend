package com.app.hospital.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class DoctorDTO {

	private int doctorId;
	@NotBlank(message="The Doctor Name  should not be blank")
    @Size(min=3,max=100)
	private String doctorName;
	
	@NotBlank(message = "The email should not be blank or empty or Null")
	@Email(message ="Please enter a valid email id",regexp = "^[a-zA-Z0-9._-]+@[a-zA-Z0-9]+\\.[a-zA-Z.]{2,5}")
	private String doctormail;
	
	@NotNull
	private Long doctorphoneNo;
	
	@NotBlank(message="The Doctor Name  should not be blank")
    @Size(min=3,max=100)
	private String specialization;
	
	@NotNull
	private int experience;
	
	@NotBlank(message="The city  should not be blank")
    @Size(min=3,max=100)
	private String city;
	private String password;
	public int getDoctorId() {
		return doctorId;
	}
	public void setDoctorId(int doctorId) {
		this.doctorId = doctorId;
	}
	public String getDoctorName() {
		return doctorName;
	}
	public void setDoctorName(String doctorName) {
		this.doctorName = doctorName;
	}
	public String getDoctormail() {
		return doctormail;
	}
	public void setDoctormail(String doctormail) {
		this.doctormail = doctormail;
	}
	public Long getDoctorphoneNo() {
		return doctorphoneNo;
	}
	public void setDoctorphoneNo(Long doctorphoneNo) {
		this.doctorphoneNo = doctorphoneNo;
	}
	public String getSpecialization() {
		return specialization;
	}
	public void setSpecialization(String specialization) {
		this.specialization = specialization;
	}
	public int getExperience() {
		return experience;
	}
	public void setExperience(int experience) {
		this.experience = experience;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
	
	
	

}