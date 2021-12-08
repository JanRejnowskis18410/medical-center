package com.pjatk.medicalcenter.dto;

import com.pjatk.medicalcenter.model.Appointment;
import com.pjatk.medicalcenter.model.Prescription;
import com.pjatk.medicalcenter.model.Referral;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor

public class AppointmentForDoctorDTO {

    private Long id;
    private List<Referral> issuedReferrals = new ArrayList<>();
    private List<Prescription> prescriptions = new ArrayList<>();
    private List<AppointmentTestDTO> appointmentCheckUps = new ArrayList<>();
    private LocalDateTime date;
    private String recommendations;
    private String description;
    private Appointment.AppointmentType type;
    private String medicalServiceName;

    public AppointmentForDoctorDTO(Appointment appointment){
        this.id = appointment.getId();
        this.date = appointment.getDate();
        this.type = appointment.getType();
        this.medicalServiceName = appointment.getMedicalService().getName();
    }
}
