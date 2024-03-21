package com.app.hospital.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.app.hospital.dto.DoctorDTO;
import com.app.hospital.entity.Doctor;
import com.app.hospital.repository.DoctorRepository;
import com.app.hospital.service.DoctorService;

@Service
public class DoctorServiceImpl implements DoctorService {

	//enables to inject the object dependency implicitly
	@Autowired
	private DoctorRepository doctorRepository;
	
//methods to save the doctor details 
	@Override
	public DoctorDTO saveDoctor(DoctorDTO doctorDTO) {
		Doctor doctor = new Doctor();
		BeanUtils.copyProperties(doctorDTO, doctor); //convert the entity to DTO
		doctorRepository.save(doctor);
		return doctorDTO;
	}
//methods to edit the doctor details
	@Override
	public DoctorDTO updateDoctor(DoctorDTO doctorDTO) {
		Doctor doctor = new Doctor();
		BeanUtils.copyProperties(doctorDTO, doctor); //convert the entity to DTO
		doctorRepository.save(doctor);
		return doctorDTO;
	}
//methods to delete the doctor details
	
	@Override
	public Boolean deleteDoctor(DoctorDTO doctorDTO) {
		Doctor doctor = new Doctor();
		BeanUtils.copyProperties(doctorDTO, doctor); //convert the entity to DTO
		doctorRepository.save(doctor);
		return true;
	}

// methods to get the doctor details by doctor Id
	@Override
	public DoctorDTO getById(int id) {
		Optional<Doctor> doctor = doctorRepository.findById(id);
		if (doctor.isPresent()) {
			DoctorDTO dto = new DoctorDTO();
			BeanUtils.copyProperties(doctor.get(), dto);//convert the entity to DTO
			return dto;

		}
		return null;
	}

// methods to find all the doctors details in the hospital
	
	@Override
	public List<DoctorDTO> findAll() {
		Iterable<Doctor> list = doctorRepository.findAll();
		List<DoctorDTO> dtos = new ArrayList<>();
		for (Doctor d : list) {
			DoctorDTO dto = new DoctorDTO();
			BeanUtils.copyProperties(d, dto); //convert the entity to DTO
			dtos.add(dto);

		}
		return dtos;
	}
	@Override
	public List<Doctor> findByCity(String city,String specialization) {
		// TODO Auto-generated method stub
		return doctorRepository.findByCityAndSpecialization(city,specialization);
	}

}
