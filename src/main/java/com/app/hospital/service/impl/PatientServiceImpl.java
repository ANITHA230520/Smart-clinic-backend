package com.app.hospital.service.impl;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.hospital.dto.PatientDTO;
import com.app.hospital.entity.Patient;
import com.app.hospital.repository.PatientRepository;
import com.app.hospital.service.PatientService;

@Service
public class PatientServiceImpl implements PatientService {
	// enables to inject the object dependency implicitly
	@Autowired
	private PatientRepository patientRepository;
	
//methods to save the patient details
	@Override
	public PatientDTO savePatient(PatientDTO patientDTO) {
		Patient patient = new Patient();
		BeanUtils.copyProperties(patientDTO, patient); //copy the entity to DTO
		patientRepository.save(patient);
		return patientDTO;
	}
	
//methods to edit  the patient details
	@Override
	public PatientDTO updatePatient(PatientDTO patientDTO) {
		Patient patient = new Patient();
		BeanUtils.copyProperties(patientDTO, patient); //copy the entity to DTO
		patientRepository.save(patient);
		return patientDTO;
	}
	
//methods to delete the patient details
	@Override
	public PatientDTO deletePatient(PatientDTO patientDTO) {
		Patient patient = new Patient();
		BeanUtils.copyProperties(patientDTO, patient); //copy the entity to DTO
		patientRepository.delete(patient);
		return patientDTO;
	}

//methods to get the patient details by patient Id
	@Override
	public PatientDTO getById(int id) {

		Optional<Patient> patient = patientRepository.findById(id);
		if (patient.isPresent()) {
			PatientDTO dto = new PatientDTO();
			BeanUtils.copyProperties(patient.get(), dto); //copy the entity to DTO
			return dto;

		}
		return null;
	}

// methods to find all the patient details 
	@Override
	public List<PatientDTO> findAll() {
		Iterable<Patient> list = patientRepository.findAll();
		List<PatientDTO> dtos = new ArrayList<>();
		for (Patient p : list) {
			PatientDTO dto = new PatientDTO();
			BeanUtils.copyProperties(p, dto); //copy the entity to DTO
			dtos.add(dto);

		}
		return dtos;
	}
}
