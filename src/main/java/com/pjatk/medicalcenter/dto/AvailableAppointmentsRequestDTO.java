package com.pjatk.medicalcenter.dto;

import com.pjatk.medicalcenter.model.Appointment;
import com.pjatk.medicalcenter.model.Doctor;
import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.lang.Nullable;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
public class AvailableAppointmentsRequestDTO {

    private Long medicalServiceId;
    @Nullable
    private Long doctorId;
    @Nullable
    private LocalDateTime dateFrom;
    @Nullable
    private LocalDateTime dateTo;
    private Doctor.Language language;
}
