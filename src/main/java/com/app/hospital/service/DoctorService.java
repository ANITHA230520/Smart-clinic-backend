package com.app.hospital.service;

import java.util.List;
import org.springframework.stereotype.Service;
import com.app.hospital.dto.DoctorDTO;
import com.app.hospital.entity.Doctor;

@Service
public interface DoctorService {

	public DoctorDTO saveDoctor(DoctorDTO doctorDTO);

	public DoctorDTO updateDoctor(DoctorDTO doctorDTO);

	public Boolean deleteDoctor(DoctorDTO doctorDTO);

	public DoctorDTO getById(int id);

	public List<DoctorDTO> findAll();

	public List<Doctor> findByCity(String city, String specialization);

}
