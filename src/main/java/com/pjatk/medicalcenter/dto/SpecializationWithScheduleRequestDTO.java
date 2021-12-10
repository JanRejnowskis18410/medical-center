package com.pjatk.medicalcenter.dto;

import com.pjatk.medicalcenter.model.Schedule;
import lombok.*;

import javax.validation.constraints.NotNull;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SpecializationWithScheduleRequestDTO {

    @NotNull
    private long specializationId;
    private List<ScheduleDTO> schedules;

}
