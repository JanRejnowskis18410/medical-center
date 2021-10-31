package com.pjatk.medicalcenter.dto;

import com.pjatk.medicalcenter.model.Appointment;
import com.pjatk.medicalcenter.model.Doctor;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Null;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.lang.Nullable;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
public class AvailableAppointmentsRequestDTO {

    @NotBlank
    private Appointment.AppointmentType type;
    @NotNull
    private long medicalServiceId;
    @Nullable
    private long doctorId;
    @Nullable
    private LocalDateTime dateFrom;
    @Nullable
    private LocalDateTime dateTo;
    @NotBlank
    private Doctor.Language language;
}
