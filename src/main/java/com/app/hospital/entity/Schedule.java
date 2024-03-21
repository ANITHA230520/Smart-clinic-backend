package com.app.hospital.entity;

import java.time.LocalDate;
import java.time.LocalTime;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "schedules")

public class Schedule {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int scheduleId;
	@JsonFormat(pattern = "dd-MM-yyyy")
	private LocalDate scheduleDate;
	@JsonFormat(pattern = "HH-mm")
	private LocalTime scheduleTime;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "doctorId")
	private Doctor doctor;

	

	public Schedule() {
		super();

	}

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

	public Doctor getDoctor() {
		return doctor;
	}

	public void setDoctor(Doctor doctor) {
		this.doctor = doctor;
	}

	

	@Override
	public String toString() {
		return "Schedule [scheduleId=" + scheduleId + ", scheduleDate=" + scheduleDate + ", scheduleTime="
				+ scheduleTime + "]";
	}

}