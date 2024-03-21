package com.app.hospital.dto;

import java.time.LocalDate;
import java.time.LocalTime;

import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonFormat;

public class ScheduleDTO {
	
	private int scheduleId;
	@NotNull
	@JsonFormat(pattern = "dd-MM-yyyy")
	private LocalDate scheduleDate;
	
	@NotNull
	@JsonFormat(pattern = "HH-mm")
	private LocalTime scheduleTime;
	private int doctorId;
	
	
	public int getScheduleId() {
		return scheduleId;
	}
	public void setScheduleId(int scheduleId) {
		this.scheduleId = scheduleId;
	}
	public LocalDate getScheduleDate() {
		return scheduleDate;
	}
	public void setScheduleDate(LocalDate scheduleDate) {
		this.scheduleDate = scheduleDate;
	}
	public LocalTime getScheduleTime() {
		return scheduleTime;
	}
	public void setScheduleTime(LocalTime scheduleTime) {
		this.scheduleTime = scheduleTime;
	}
	
	public int getDoctorId() {
		return doctorId;
	}
	public void setDoctorId(int doctorId) {
		this.doctorId = doctorId;
	}
	
	
	
	
	
	
	
	
    
	
	
	
}
