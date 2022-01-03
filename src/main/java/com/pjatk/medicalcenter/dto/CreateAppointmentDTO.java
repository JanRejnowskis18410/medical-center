package com.pjatk.medicalcenter.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.lang.Nullable;

import javax.validation.constraints.Future;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
public class CreateAppointmentDTO {

    @NotNull(message = "Appointment date required")
    @Future(message = "Incorrect date")
    private LocalDateTime date;
    @NotNull(message = "Medical service id required")
    private Long medicalServiceId;
    @NotNull
    private Long doctorId;
}
