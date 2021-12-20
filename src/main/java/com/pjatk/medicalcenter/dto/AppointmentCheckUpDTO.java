package com.pjatk.medicalcenter.dto;

import com.pjatk.medicalcenter.model.AppointmentCheckUp;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
public class AppointmentCheckUpDTO {

    private long appointmentId;
    private long checkUpId;
    private LocalDateTime appointmentDate;
    private String diagnosticTestName;
    private String result;
    private String doctorsDescription;
    private Byte[] file;
    private PatientDTO patient;

    public AppointmentCheckUpDTO(AppointmentCheckUp appointmentCheckUp) {
        this.appointmentId = appointmentCheckUp.getAppointment().getId();
        this.checkUpId = appointmentCheckUp.getCheckUp().getId();
        this.appointmentDate = appointmentCheckUp.getAppointment().getDate();
        this.diagnosticTestName = appointmentCheckUp.getCheckUp().getName();
        this.result = appointmentCheckUp.getResult();
        this.doctorsDescription = appointmentCheckUp.getDoctorsDescription();
        this.file = appointmentCheckUp.getFile();
        this.patient = new PatientDTO(appointmentCheckUp.getAppointment().getPatient());
    }
}
