package com.pjatk.medicalcenter.dto;

import com.pjatk.medicalcenter.model.Appointment;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
public class CreateAppointmentDTO {

    private Long id;

    private LocalDateTime date;

    private Appointment.AppointmentType type;

    private Long serviceId;
}
