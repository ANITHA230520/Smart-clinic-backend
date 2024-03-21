package com.app.hospital.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.app.hospital.entity.Patient;

@Repository
public interface PatientRepository extends CrudRepository<Patient, Integer> {
	Iterable<Patient> findAll();

	

}
