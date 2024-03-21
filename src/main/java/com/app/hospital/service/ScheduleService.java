package com.app.hospital.service;

import java.util.List;
import com.app.hospital.dto.ScheduleDTO;
import com.app.hospital.entity.Doctor;
import com.app.hospital.entity.Schedule;

public interface ScheduleService {

	public Schedule  saveSchedule(ScheduleDTO scheduleDTO);
	
	public Schedule updateSchedule(ScheduleDTO scheduleDTO);
	
	public  ScheduleDTO deleteSchedule(ScheduleDTO scheduleDTO);

	public Doctor getDoctorByScheduleId(Integer ScheduleId);
	
	public List<ScheduleDTO> findAll();


}
