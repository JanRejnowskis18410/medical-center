package com.pjatk.medicalcenter.dto;

import com.pjatk.medicalcenter.model.Schedule;
import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SpecializationWithScheduleRequestDTO {

    @NonNull
    private long specializationId;
    private List<ScheduleDTO> schedules;

}
