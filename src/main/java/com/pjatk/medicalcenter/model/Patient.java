package com.pjatk.medicalcenter.model;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Patient extends Person{

    @Embedded
    private Address address;

    @Column(name = "phoneNumber", nullable = false, length = 15, unique = true)
    private String phoneNumber;

    @OneToMany(mappedBy = "patient")
    private List<Referral> referrals = new ArrayList<>();

    @OneToMany(mappedBy = "patient")
    private List<Prescription> prescriptions = new ArrayList<>();

    @OneToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL,mappedBy = "patient")
    @Setter(AccessLevel.NONE)
    private List<PatientsFile> patientsFiles = new ArrayList<>();

    @OneToMany(mappedBy = "patient")
    private List<Appointment> appointments = new ArrayList<>();

    public void setPatientsFiles(List<PatientsFile> patientsFiles) {
        patientsFiles.forEach(e -> e.setPatient(this));
        this.patientsFiles = patientsFiles;
    }

    public void addReferral(Referral referral) {
        referrals.add(referral);
    }

    public void addAppointment(Appointment appointment) {
        appointments.add(appointment);
    }

    public void addPrescription(Prescription prescription) {
        prescriptions.add(prescription);
    }
}
