package com.pjatk.medicalcenter.dto;

import com.pjatk.medicalcenter.model.Appointment;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
public class AvailableAppointmentDTO {

    private Long id;
    private MedicalServiceDTO service;
    private DoctorDTO doctor;
    private LocalDateTime date;
    private boolean confirmed;
    private Appointment.AppointmentType type;
    private Appointment.AppointmentState state;

    public AvailableAppointmentDTO(Appointment appointment) {
        this.id = appointment.getId();
        this.service = new MedicalServiceDTO(appointment.getMedicalService());
        this.doctor = new DoctorDTO(appointment.getDoctor());
        this.date = appointment.getDate();
        this.type = appointment.getType();
        this.state = appointment.getState();
    }
}
