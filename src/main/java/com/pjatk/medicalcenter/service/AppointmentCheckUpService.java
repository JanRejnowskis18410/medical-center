package com.pjatk.medicalcenter.service;

import com.pjatk.medicalcenter.model.AppointmentCheckUp;
import com.pjatk.medicalcenter.repository.AppointmentCheckUpRepository;
import org.springframework.stereotype.Service;


@Service
public class AppointmentCheckUpService {

    private final AppointmentCheckUpRepository appointmentCheckUpRepository;

    public AppointmentCheckUpService(AppointmentCheckUpRepository appointmentCheckUpRepository) {
        this.appointmentCheckUpRepository = appointmentCheckUpRepository;
    }

    public AppointmentCheckUp saveAppointmentCheckUp(AppointmentCheckUp appointmentCheckUp) {
        return appointmentCheckUpRepository.save(appointmentCheckUp);
    }

    public AppointmentCheckUp getAppointmentCheckUp(Long appointmentId, Long checkUpId) {
        return appointmentCheckUpRepository.findAppointmentCheckUpByAppointmentIdAndCheckUpId(appointmentId,checkUpId);
    }
}
