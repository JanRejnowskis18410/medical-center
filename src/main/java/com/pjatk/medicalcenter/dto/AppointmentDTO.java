package com.pjatk.medicalcenter.dto;

import com.pjatk.medicalcenter.model.Appointment;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
public class AppointmentDTO {

    private Long id;

    private MedicalServiceDTO service;

    private DoctorDTO doctor;

    private LocalDateTime date;

    private boolean confirmed;

    private String description;

    private Appointment.AppointmentType type;

    public AppointmentDTO(Appointment appointment) {
        this.id = appointment.getId();
        this.service = new MedicalServiceDTO(appointment.getMedicalService());
        this.doctor = new DoctorDTO(appointment.getDoctor());
        this.date = appointment.getDate();
        this.confirmed = appointment.isConfirmed();
        this.description = appointment.getDescription();
        this.type = appointment.getType();
    }
}
