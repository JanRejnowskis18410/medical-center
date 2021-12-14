package com.pjatk.medicalcenter.model;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@AllArgsConstructor
@Data
public class Appointment {

    public enum AppointmentType {
        TELEPHONE, FACILITY
    }

    public enum AppointmentState {
        AVAILABLE, RESERVED, CONFIRMED, DONE
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "patient_id", referencedColumnName = "id", nullable = true)
    @Setter(AccessLevel.NONE)
    private Patient patient;

    @ManyToOne
    @JoinColumn(name = "doctor_id", referencedColumnName = "id", nullable = true)
    @Setter(AccessLevel.NONE)
    private Doctor doctor;

    @ManyToOne(optional = false)
    @JoinColumn(name = "medicalService_id", referencedColumnName = "id", nullable = false)
    @Setter(AccessLevel.NONE)
    private MedicalService medicalService;

    @OneToOne(mappedBy = "appointment")
    @Setter(AccessLevel.NONE)
    private Referral referral = null;

    @OneToMany(mappedBy = "issueAppointment")
    private List<Referral> issuedReferrals = new ArrayList<>();

    @OneToMany(mappedBy = "appointment")
    private List<Prescription> prescriptions = new ArrayList<>();

    @OneToMany(mappedBy = "appointment")
    private List<AppointmentCheckUp> appointmentCheckUps = new ArrayList<>();

    @Column(nullable = false)
    private LocalDateTime date;

    @Column(nullable = true, length = 500)
    private String recommendations;

    @Column(nullable = true, length = 500)
    private String description;

    @Column(name = "type", nullable = false)
    @Enumerated(EnumType.STRING)
    private AppointmentType type;

    @Column(name = "state", nullable = false, columnDefinition = "varchar(255) default 'AVAILABLE'")
    @Enumerated(EnumType.STRING)
    private AppointmentState state;

    public Appointment(){
        this.state = AppointmentState.AVAILABLE;
    }

    public void setMedicalService(MedicalService medicalService) {
        this.medicalService = medicalService;
        medicalService.addAppointment(this);
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
        doctor.addAppointment(this);
    }

    public void setPatient(Patient patient) {
        if (this.patient != null) {
            if(patient == null) {
                this.patient.getAppointments().remove(this);
                this.patient = null;
            } else {
                this.patient.getAppointments().remove(this);
                this.patient = patient;
                patient.addAppointment(this);
            }
        } else {
            if (patient != null) {
                this.patient = patient;
                patient.addAppointment(this);
            }
        }
    }

    public void addIssuedReferral(Referral issuedReferral) {
        issuedReferrals.add(issuedReferral);
    }

    public void setReferral(Referral referral) {
        if(this.referral != null) {
            if (referral == null) {
                this.referral.setAppointment(null);
                this.referral = null;
            } else {
                this.referral = referral;
                referral.setAppointment(this);
            }
        } else {
            if (referral != null) {
                this.referral = referral;
                referral.setAppointment(this);
            }
        }
    }

    public void addPrescription(Prescription prescription) {
        prescriptions.add(prescription);
    }

    public void addAppointmentCheckUp(AppointmentCheckUp appointmentCheckUp) {
        appointmentCheckUps.add(appointmentCheckUp);
    }
}
