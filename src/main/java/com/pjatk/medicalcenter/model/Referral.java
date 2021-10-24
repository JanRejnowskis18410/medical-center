package com.pjatk.medicalcenter.model;

import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@NoArgsConstructor
@Data
public class Referral {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(
            nullable = false
    )
    private LocalDate issueDate;

    @Column(
            nullable = false
    )
    private LocalDate expiryDate;

    @OneToOne
    private Appointment appointment;

    @ManyToOne(optional = false)
    @Setter(AccessLevel.NONE)
    private Appointment issueAppointment;

    @ManyToOne(optional = false)
    @Setter(AccessLevel.NONE)
    private MedicalService medicalService;

    @ManyToOne(optional = false)
    @Setter(AccessLevel.NONE)
    private Patient patient;

    public void setMedicalService(MedicalService medicalService) {
        this.medicalService = medicalService;
        medicalService.addReferral(this);
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
        patient.addReferral(this);
    }

    public void setIssueAppointment(Appointment issueAppointment) {
        this.issueAppointment = issueAppointment;
        issueAppointment.addIssuedReferral(this);
    }
}
