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

    private ServiceDTO service;

    private LocalDateTime date;

    private boolean confirmed;

    private String description;

    private Appointment.AppointmentType type;

    public AppointmentDTO(Appointment appointment) {
        this.id = appointment.getId();
        this.service = new ServiceDTO(appointment.getService());
        this.date = appointment.getDate();
        this.confirmed = appointment.isConfirmed();
        this.description = appointment.getDescription();
        this.type = appointment.getType();
    }
}
