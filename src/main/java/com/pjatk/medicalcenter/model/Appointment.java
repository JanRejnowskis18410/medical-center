package com.pjatk.medicalcenter.model;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor
@Getter
@Setter
public class Appointment {

    public enum AppointmentType {
        TELEPHONE, FACILITY
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @Setter(AccessLevel.NONE)
    private Patient patient;

    @ManyToOne(optional = false)
    @Setter(AccessLevel.NONE)
    private MedicalService medicalService;

    @OneToOne(mappedBy = "appointment")
    @Setter(AccessLevel.NONE)
    private Referral referral;

    @OneToMany(mappedBy = "issueAppointment")
    private List<Referral> issuedReferrals = new ArrayList<>();

    @Column(
            nullable = false
    )
    private LocalDateTime date;

    @Column(
            nullable = false
    )
    @Type(type = "numeric_boolean")
    private boolean confirmed;

    @Column
    private String recommendations;

    @Column
    private String description;

    @Column(
            nullable = false
    )
    @Enumerated(EnumType.STRING)
    private AppointmentType type;

    public void setMedicalService(MedicalService medicalService) {
        this.medicalService = medicalService;
        medicalService.addAppointment(this);
    }

    public void addIssuedReferral(Referral issuedReferral) {
        issuedReferrals.add(issuedReferral);
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
        patient.addAppointment(this);
    }

    public void setReferral(Referral referral) {
        this.referral = referral;
        referral.setAppointment(this);
    }
}
