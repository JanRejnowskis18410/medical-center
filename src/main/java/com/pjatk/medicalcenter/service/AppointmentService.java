package com.pjatk.medicalcenter.service;

import com.pjatk.medicalcenter.model.Appointment;
import com.pjatk.medicalcenter.repository.AppointmentRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class AppointmentService {

    private final AppointmentRepository appointmentRepository;

    public AppointmentService(AppointmentRepository appointmentRepository) {
        this.appointmentRepository = appointmentRepository;
    }

    public List<Appointment> getAvailableAppointments(Appointment.AppointmentType appointmentType) {
        LocalDateTime now = LocalDateTime.now();
        return this.appointmentRepository.findByTypeAndPatientIsNullAndDateAfter(appointmentType,now);
    }

    public Appointment getAppointmentById(long id){
        return appointmentRepository.findById(id).orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND,"Appointment does not exists"));
    }

    public Appointment addAppointment(Appointment appointment) {
        return appointmentRepository.save(appointment);
    }

    public List<Appointment> addAppointments(List<Appointment> appointments) {
        return appointmentRepository.saveAll(appointments);
    }

    public void deleteAppointmentById(long id){
        appointmentRepository.delete(appointmentRepository.findById(id).orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND,"Appointment does not exists")));
    }
}

