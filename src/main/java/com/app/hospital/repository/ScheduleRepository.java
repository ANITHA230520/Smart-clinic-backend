package com.app.hospital.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.app.hospital.entity.Doctor;
import com.app.hospital.entity.Schedule;

@Repository

public interface ScheduleRepository extends CrudRepository<Schedule, Integer> {

	@Query(value = "select d from Doctor d where d.doctorId in (select s.doctor from Schedule s where s.scheduleId = :sid) ")
	Doctor searchByScheduleId(@Param("sid") Integer ScheduleId);

}
