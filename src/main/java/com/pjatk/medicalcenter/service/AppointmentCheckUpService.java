package com.pjatk.medicalcenter.service;

import com.pjatk.medicalcenter.model.Appointment;
import com.pjatk.medicalcenter.model.AppointmentCheckUp;
import com.pjatk.medicalcenter.repository.AppointmentCheckUpRepository;
import com.pjatk.medicalcenter.repository.AppointmentRepository;
import com.pjatk.medicalcenter.security.model.AppRole;
import com.pjatk.medicalcenter.security.service.AccessService;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import static com.pjatk.medicalcenter.util.ErrorMessages.APPOINTMENT_NOT_FOUND_ERROR_MESS;


@Service
public class AppointmentCheckUpService {

    private final AppointmentCheckUpRepository appointmentCheckUpRepository;
    private final AppointmentRepository appointmentRepository;
    private final AccessService accessService;

    public AppointmentCheckUpService(
            AppointmentCheckUpRepository appointmentCheckUpRepository,
            AppointmentRepository appointmentRepository,
            AccessService accessService) {
        this.appointmentCheckUpRepository = appointmentCheckUpRepository;
        this.appointmentRepository = appointmentRepository;
        this.accessService = accessService;
    }

    public AppointmentCheckUp saveAppointmentCheckUp(AppointmentCheckUp appointmentCheckUp) {
        return appointmentCheckUpRepository.save(appointmentCheckUp);
    }

    public AppointmentCheckUp getAppointmentCheckUp(Long appointmentId, Long checkUpId, Authentication auth, AppRole role) {
        Appointment appointment = appointmentRepository.findById(appointmentId)
                .orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND,APPOINTMENT_NOT_FOUND_ERROR_MESS));
        if(role.equals(AppRole.DOCTOR)){
            accessService.authenticatePerson(auth,appointment.getDoctor().getId());
        } else if (role.equals(AppRole.PATIENT)) {
            accessService.authenticatePerson(auth, appointment.getPatient().getId());
        }
        return appointmentCheckUpRepository.findAppointmentCheckUpByAppointmentIdAndCheckUpId(appointmentId,checkUpId);
    }
}
