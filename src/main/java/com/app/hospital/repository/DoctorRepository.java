package com.app.hospital.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.app.hospital.entity.Doctor;

@Repository

public interface DoctorRepository extends CrudRepository<Doctor, Integer> {

	Iterable<Doctor> findAll();

	
	//@Query(value = "SELECT * FROM doctors d WHERE d.city = ?1", nativeQuery = true)
	List<Doctor> findByCityAndSpecialization(String city, String specialization);



}