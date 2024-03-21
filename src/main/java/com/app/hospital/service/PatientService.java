package com.app.hospital.service;

import java.util.List;
import com.app.hospital.dto.PatientDTO;


public interface PatientService {
	
    public PatientDTO savePatient(PatientDTO patientDTO);
	
	public PatientDTO updatePatient(PatientDTO patientDTO);
	
	public PatientDTO deletePatient(PatientDTO patientDTO);
	
	public PatientDTO getById(int id);
	
	public List<PatientDTO> findAll();
	

}
