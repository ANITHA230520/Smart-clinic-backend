package com.app.hospital.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "doctors")
public class Doctor {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int doctorId;
	private String doctorName;
	private String doctormail;
	private Long doctorphoneNo;
	private String password;
	private String specialization;
	private int experience;
	private String city;

	public Doctor() {
		super();

	}

	public Doctor(int doctorId, String doctorName, String doctormail, Long doctorphoneNo, String password,
			String specialization, int experience, String city) {
		super();
		this.doctorId = doctorId;
		this.doctorName = doctorName;
		this.doctormail = doctormail;
		this.doctorphoneNo = doctorphoneNo;
		this.password = password;
		this.specialization = specialization;
		this.experience = experience;
		this.city = city;
	}

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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
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

	@Override
	public String toString() {
		return "Doctor [doctorId=" + doctorId + ", doctorName=" + doctorName + ", doctormail=" + doctormail
				+ ", doctorphoneNo=" + doctorphoneNo + ", password=" + password + ", specialization=" + specialization
				+ ", experience=" + experience + ", city=" + city + "]";
	}
	

}