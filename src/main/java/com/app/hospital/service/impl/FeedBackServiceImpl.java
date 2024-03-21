package com.app.hospital.service.impl;



import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.hospital.dto.FeedBackDTO;

import com.app.hospital.entity.Doctor;
import com.app.hospital.entity.FeedBack;
import com.app.hospital.entity.Patient;

import com.app.hospital.exceptions.DoctorNotFoundException;
import com.app.hospital.exceptions.PatientNotFoundException;
import com.app.hospital.repository.DoctorRepository;
import com.app.hospital.repository.FeedBackRepository;
import com.app.hospital.repository.PatientRepository;
import com.app.hospital.service.FeedBackService;

@Service
public class FeedBackServiceImpl implements FeedBackService {
	// enables to inject the object dependency implicitly
	@Autowired
	private FeedBackRepository feedBackRepository;

	@Autowired
	private DoctorRepository doctorRepository;

	@Autowired
	private PatientRepository patientRepository;

//methods to save the feedback details given by patientId to doctor Id
	@Override
	public FeedBack saveFeedBack(FeedBackDTO feedBackDTO) {
		int did = feedBackDTO.getDoctorId();
		int pid = feedBackDTO.getPatientId();

		Doctor doctor = doctorRepository.findById(did).orElseThrow(() -> new DoctorNotFoundException());
		Patient patient = patientRepository.findById(pid).orElseThrow(() -> new PatientNotFoundException());

		FeedBack feedBack = new FeedBack();
		BeanUtils.copyProperties(feedBackDTO, feedBack); // copy the entity to DTO
		feedBack.setDoctor(doctor);
		feedBack.setPatient(patient);
		feedBack = feedBackRepository.save(feedBack);
		return feedBack;
	}

	@Override
	public List<FeedBackDTO> findAll() {
		int patientId = 0;

		int doctorId = 0;

		Iterable<FeedBack> list = feedBackRepository.findAll();

		List<FeedBackDTO> dtos = new ArrayList<>();

		for (FeedBack f : list) {

			FeedBackDTO dto = new FeedBackDTO();

			BeanUtils.copyProperties(f, dto); // convert the entity to DTO

			if (f.getPatient() != null) {

				patientId = f.getPatient().getPatientId();

			}

			if (f.getDoctor() != null) {

				doctorId = f.getDoctor().getDoctorId();

			}

			dto.setPatientId(patientId);

			dto.setDoctorId(doctorId);

			dtos.add(dto);

		}

		return dtos;
	}

}
