package com.app.hospital.entity;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "feedBacks")
public class FeedBack {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int feedBackId;
	private int rating;
	private String comments;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "patientId")
	private Patient patient;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "doctorId")
	private Doctor doctor;

	public FeedBack() {
		super();

	}

	public FeedBack(int feedBackId, int rating, String comments, Patient patient, Doctor doctor) {
		super();
		this.feedBackId = feedBackId;
		this.rating = rating;
		this.comments = comments;
		this.patient = patient;
		this.doctor = doctor;
	}

	public int getFeedBackId() {
		return feedBackId;
	}

	public void setFeedBackId(int feedbackId) {
		this.feedBackId = feedbackId;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	public Patient getPatient() {
		return patient;
	}

	public void setPatient(Patient patient) {
		this.patient = patient;
	}

	public Doctor getDoctor() {
		return doctor;
	}

	public void setDoctor(Doctor doctor) {
		this.doctor = doctor;
	}

	@Override
	public String toString() {
		return "FeedBack [feedBackId=" + feedBackId + ", rating=" + rating + ", comments=" + comments + ", patient="
				+ patient + ", doctor=" + doctor + "]";
	}

}
