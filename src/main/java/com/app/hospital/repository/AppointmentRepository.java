package com.app.hospital.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.app.hospital.entity.Appointment;

@Repository
public interface AppointmentRepository extends CrudRepository<Appointment, Integer> {

	Iterable<Appointment> findAll();

}
