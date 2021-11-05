package com.pjatk.medicalcenter.model;

import lombok.*;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import javax.print.Doc;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Appointment {

    public enum AppointmentType {
        TELEPHONE, FACILITY
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "patient_id", referencedColumnName = "id")
    @Setter(AccessLevel.NONE)
    private Patient patient;

    @ManyToOne
    @JoinColumn(name = "doctor_id", referencedColumnName = "id")
    @Setter(AccessLevel.NONE)
    private Doctor doctor;

    @ManyToOne(optional = false)
    @JoinColumn(name = "medicalService_id", referencedColumnName = "id")
    @Setter(AccessLevel.NONE)
    private MedicalService medicalService;

    @OneToOne(mappedBy = "appointment")
    private Referral referral;

    @OneToMany(mappedBy = "issueAppointment")
    private List<Referral> issuedReferrals = new ArrayList<>();

    @Column(nullable = false)
    private LocalDateTime date;

    @Column(nullable = false)
    @Type(type = "numeric_boolean")
    private boolean confirmed;

    @Column
    private String recommendations;

    @Column
    private String description;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private AppointmentType type;

    public void setMedicalService(MedicalService medicalService) {
        this.medicalService = medicalService;
        medicalService.addAppointment(this);
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
        doctor.addAppointment(this);
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
        patient.addAppointment(this);
    }

    public void addIssuedReferral(Referral issuedReferral) {
        issuedReferrals.add(issuedReferral);
    }

}
