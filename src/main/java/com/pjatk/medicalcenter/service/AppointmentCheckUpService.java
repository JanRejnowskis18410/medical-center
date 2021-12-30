package com.pjatk.medicalcenter.service;

import com.pjatk.medicalcenter.model.Appointment;
import com.pjatk.medicalcenter.model.AppointmentCheckUp;
import com.pjatk.medicalcenter.repository.AppointmentCheckUpRepository;
import com.pjatk.medicalcenter.security.model.AppRole;
import com.pjatk.medicalcenter.security.service.AccessService;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;


@Service
public class AppointmentCheckUpService {

    private final AppointmentCheckUpRepository appointmentCheckUpRepository;
    private final AppointmentService appointmentService;
    private final AccessService accessService;

    public AppointmentCheckUpService(
            AppointmentCheckUpRepository appointmentCheckUpRepository,
            AppointmentService appointmentService,
            AccessService accessService) {
        this.appointmentCheckUpRepository = appointmentCheckUpRepository;
        this.appointmentService = appointmentService;
        this.accessService = accessService;
    }

    public AppointmentCheckUp saveAppointmentCheckUp(AppointmentCheckUp appointmentCheckUp) {
        return appointmentCheckUpRepository.save(appointmentCheckUp);
    }

    public AppointmentCheckUp getAppointmentCheckUp(Long appointmentId, Long checkUpId, Authentication auth, AppRole role) {
        Appointment appointment = appointmentService.getAppointmentById(appointmentId);
        if(role.equals(AppRole.DOCTOR)){
            accessService.authenticatePerson(auth,appointment.getDoctor().getId());
        } else if (role.equals(AppRole.PATIENT)) {
            accessService.authenticatePerson(auth, appointment.getPatient().getId());
        }
        return appointmentCheckUpRepository.findAppointmentCheckUpByAppointmentIdAndCheckUpId(appointmentId,checkUpId);
    }
}
