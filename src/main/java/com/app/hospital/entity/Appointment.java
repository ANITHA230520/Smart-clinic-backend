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
@Entity
@Table(name ="appointments")
public class Appointment {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int appointmentId;
	
	private LocalDate date;
	private LocalTime time;
    private String symptoms;
	
    //single valued association 
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="patientId")
	private Patient patient;
	
	//eagerly fetches the data
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="scheduleId")
    private Schedule schedule;

	public Appointment() {
		super();

	}

	public Appointment(int appointmentId, LocalDate date, LocalTime time, String symptoms, Patient patient,
			Schedule schedule) {
		super();
		this.appointmentId = appointmentId;
		this.date = date;
		this.time = time;
		this.symptoms = symptoms;
		this.patient = patient;
		this.schedule = schedule;
	}

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

	public Patient getPatient() {
		return patient;
	}

	public void setPatient(Patient patient) {
		this.patient = patient;
	}

	public Schedule getSchedule() {
		return schedule;
	}

	public void setSchedule(Schedule schedule) {
		this.schedule = schedule;
	}

	@Override
	public String toString() {
		return "Appointment [appointmentId=" + appointmentId + ", date=" + date + ", time=" + time + ", symptoms="
				+ symptoms + ", patient=" + patient + ", schedule=" + schedule + "]";
	}

}