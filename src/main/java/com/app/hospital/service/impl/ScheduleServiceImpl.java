package com.app.hospital.service.impl;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.app.hospital.dto.ScheduleDTO;
import com.app.hospital.entity.Doctor;
import com.app.hospital.entity.Schedule;
import com.app.hospital.exceptions.ScheduleNotFoundException;
import com.app.hospital.repository.DoctorRepository;
import com.app.hospital.repository.ScheduleRepository;
import com.app.hospital.service.ScheduleService;

@Service
public class ScheduleServiceImpl implements ScheduleService {
	// enables to inject the object dependency implicitly
	@Autowired
	private ScheduleRepository scheduleRepository;
	
	@Autowired
	private DoctorRepository doctorRepository;

// methods to save the schedule details by getting the Doctor Id
	@Override
	public Schedule saveSchedule(ScheduleDTO scheduleDTO) {
		int did =scheduleDTO.getDoctorId();
		
		Doctor doctor= doctorRepository.findById(did).get();
		if(doctor !=null) {
			Schedule schedule =new Schedule();
			BeanUtils.copyProperties(scheduleDTO, schedule); //convert the entity to DTO
		    schedule.setDoctor(doctor);
		    schedule=scheduleRepository.save(schedule);
		    return schedule;
	   }
	   return null;
	}

// methods to edit the schedule details 
	
	@Override
	public Schedule updateSchedule(ScheduleDTO scheduleDTO) {
		int did =scheduleDTO.getDoctorId();
		
		Doctor doctor= doctorRepository.findById(did).get();
		if(doctor !=null) {
			Schedule schedule =new Schedule();
			BeanUtils.copyProperties(scheduleDTO, schedule); //convert the entity to DTO
		    schedule.setDoctor(doctor);
	        schedule=scheduleRepository.save(schedule);
		    return schedule;
	   }
	   return null;
	}
// method to delete the schedule details
	
	@Override
	public ScheduleDTO deleteSchedule(ScheduleDTO scheduleDTO) {
		int did =scheduleDTO.getDoctorId();
		
		Doctor doctor= doctorRepository.findById(did).orElseThrow(()->new ScheduleNotFoundException());
		if(doctor !=null) {
			Schedule schedule =new Schedule();
			BeanUtils.copyProperties(scheduleDTO, schedule);
		    schedule.setDoctor(doctor);
	        schedule=scheduleRepository.save(schedule);
	        }
		    return scheduleDTO;
	}

// method to get doctor by schedule Id
	@Override
	public Doctor getDoctorByScheduleId(Integer ScheduleId) {
		Doctor d= scheduleRepository.searchByScheduleId(ScheduleId);
		if (d!=null) {
			return d;

		}
		return null;
	}
// method to get all the schedules
	@Override
	public List<ScheduleDTO> findAll() {
        
		Iterable<Schedule> list = scheduleRepository.findAll();
		List<ScheduleDTO> dtos = new ArrayList<>();
		for (Schedule s : list) {
			ScheduleDTO dto = new ScheduleDTO();
			BeanUtils.copyProperties(s, dto);
			int doctorId=s.getDoctor().getDoctorId();
			dto.setDoctorId(doctorId);
			dtos.add(dto);

		}
		return dtos;
	}

}
