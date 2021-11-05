package com.pjatk.medicalcenter.dto;

import com.pjatk.medicalcenter.model.Appointment;
import com.pjatk.medicalcenter.model.Doctor;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.lang.Nullable;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
public class CreateAppointmentDTO {

    @NotNull
    private LocalDateTime date;
    @NotNull
    private Long medicalServiceId;
    @Nullable
    private Long doctorId;
}
