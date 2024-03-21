package com.app.hospital.service;

import java.util.List;
import com.app.hospital.dto.AppointmentDTO;
import com.app.hospital.entity.Appointment;

public interface AppointmentService {

	public Appointment saveAppoinments(AppointmentDTO appointmentDTO);

	public Appointment updateAppointment(AppointmentDTO appointmentDTO);

	public List<AppointmentDTO> findAll();

}
