package com.app.hospital.service.impl;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.app.hospital.dto.AppointmentDTO;
import com.app.hospital.entity.Appointment;
import com.app.hospital.entity.Patient;
import com.app.hospital.entity.Schedule;
import com.app.hospital.exceptions.ScheduleNotFoundException;
import com.app.hospital.repository.AppointmentRepository;
import com.app.hospital.repository.PatientRepository;
import com.app.hospital.repository.ScheduleRepository;
import com.app.hospital.service.AppointmentService;

@Service
public class AppointmentServiceImpl implements AppointmentService {

	// enables to inject the object dependency implicitly

	@Autowired
	private AppointmentRepository appointmentRepository;

	@Autowired
	private ScheduleRepository scheduleRepository;

	@Autowired
	private PatientRepository patientRepository;

// method to save the Appointment details by getting ScheduleId and PatientId
	@Override
	public Appointment saveAppoinments(AppointmentDTO appointmentDTO) {
		int pid = appointmentDTO.getPatientId();
		int sid = appointmentDTO.getScheduleId();

		// getting id and throwing exception if id is null
		Schedule schedule = scheduleRepository.findById(sid).orElseThrow(() -> new ScheduleNotFoundException());
		Patient patient = patientRepository.findById(pid).orElseThrow(() -> new ScheduleNotFoundException());

		Appointment appointment = new Appointment();
		appointment.setSchedule(schedule);
		appointment.setPatient(patient);
		appointment.setDate(appointmentDTO.getDate());
		appointment.setSymptoms(appointmentDTO.getSymptoms());
		appointment.setTime(appointmentDTO.getTime());
		appointment = appointmentRepository.save(appointment);
		return appointment;

	}

// method to edit  the Appointment details by getting ScheduleId and PatientId
	@Override
	public Appointment updateAppointment(AppointmentDTO appointmentDTO) {
		int pid = appointmentDTO.getPatientId();
		int sid = appointmentDTO.getScheduleId();

		// getting id and throwing exception if id is null
		Schedule schedule = scheduleRepository.findById(sid).orElseThrow(() -> new ScheduleNotFoundException());
		Patient patient = patientRepository.findById(pid).orElseThrow(() -> new ScheduleNotFoundException());

		Appointment appointment = new Appointment();
		appointment.setSchedule(schedule);
		appointment.setPatient(patient);
		appointment.setDate(appointmentDTO.getDate());
		appointment.setSymptoms(appointmentDTO.getSymptoms());
		appointment.setTime(appointmentDTO.getTime());
		appointment = appointmentRepository.save(appointment);
		return appointment;
	}

	@Override
	public List<AppointmentDTO> findAll() {
		int patientId = 0;
		int scheduleId = 0;
		Iterable<Appointment> list = appointmentRepository.findAll();
		List<AppointmentDTO> dtos = new ArrayList<>();
		for (Appointment s : list) {
			AppointmentDTO dto = new AppointmentDTO();
			BeanUtils.copyProperties(s, dto);
			if (s.getPatient() != null) {
				patientId = s.getPatient().getPatientId();
			}
			if (s.getSchedule() != null) {
				scheduleId = s.getSchedule().getScheduleId();
			}
			dto.setPatientId(patientId);
			dto.setScheduleId(scheduleId);
            dtos.add(dto);

		}
		return dtos;
	}



}