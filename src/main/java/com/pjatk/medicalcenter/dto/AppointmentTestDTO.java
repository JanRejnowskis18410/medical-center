package com.pjatk.medicalcenter.dto;

import com.pjatk.medicalcenter.model.AppointmentCheckUp;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class AppointmentTestDTO {

    private long appointmentId;
    private long checkUpId;
    private String diagnosticTestName;
    private String result;
    private String description;
    private byte[] file;

    public AppointmentTestDTO(AppointmentCheckUp appointmentCheckUp) {
        this.appointmentId = appointmentCheckUp.getAppointment().getId();
        this.checkUpId = appointmentCheckUp.getCheckUp().getId();
        this.diagnosticTestName = appointmentCheckUp.getCheckUp().getName();
        this.result = appointmentCheckUp.getResult();
        this.description = appointmentCheckUp.getDescription();
        this.file = appointmentCheckUp.getFile();
    }
}
