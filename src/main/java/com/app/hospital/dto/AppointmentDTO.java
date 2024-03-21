package com.app.hospital.dto;

import java.time.LocalDate;
import java.time.LocalTime;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonFormat;

public class AppointmentDTO {

	private int appointmentId;
	@NotNull
	@JsonFormat(pattern = "dd-MM-yyyy")
	private LocalDate date;

	@NotNull
	@JsonFormat(pattern = "HH-mm")
	private LocalTime time;

	@NotBlank(message = "The remark should  not be blank")
	@Size(min = 3, max = 100)
	private String symptoms;

	@NotNull
	private int patientId;

	@NotNull
	private int scheduleId;
	
	

	public int getAppointmentId() {
		return appointmentId;
	}

	public void setAppointmentId(int appointmentId) {
		this.appointmentId = appointmentId;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public LocalTime getTime() {
		return time;
	}

	public void setTime(LocalTime time) {
		this.time = time;
	}

	public String getSymptoms() {
		return symptoms;
	}

	public void setSymptoms(String symptoms) {
		this.symptoms = symptoms;
	}

	public int getPatientId() {
		return patientId;
	}

	public void setPatientId(int patientId) {
		this.patientId = patientId;
	}

	public int getScheduleId() {
		return scheduleId;
	}

	public void setScheduleId(int scheduleId) {
		this.scheduleId = scheduleId;
	}

}
