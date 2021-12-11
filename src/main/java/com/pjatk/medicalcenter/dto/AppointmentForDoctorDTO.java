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
import java.util.stream.Collectors;

@Getter
@Setter
@NoArgsConstructor

public class AppointmentForDoctorDTO {

    private Long id;
    private List<ReferralDTO> issuedReferrals = new ArrayList<>();
    private List<PrescriptionDTO> prescriptions = new ArrayList<>();
    private List<AppointmentTestDTO> appointmentCheckUps = new ArrayList<>();
    private LocalDateTime date;
    private String recommendations;
    private String description;
    private Appointment.AppointmentType type;
    private String medicalServiceName;
    private PatientDTO patient;

    public AppointmentForDoctorDTO(Appointment appointment){
        this.id = appointment.getId();
        this.date = appointment.getDate();
        this.type = appointment.getType();
        this.medicalServiceName = appointment.getMedicalService().getName();
        this.patient = new PatientDTO(appointment.getPatient());
        this.appointmentCheckUps = appointment.getAppointmentCheckUps().stream().map(AppointmentTestDTO::new).collect(Collectors.toList());
        this.recommendations = appointment.getRecommendations();
        this.description = appointment.getDescription();
        this.prescriptions = appointment.getPrescriptions().stream().map(PrescriptionDTO::new).collect(Collectors.toList());
        this.issuedReferrals = appointment.getIssuedReferrals().stream().map(ReferralDTO::new).collect(Collectors.toList());
    }
}
