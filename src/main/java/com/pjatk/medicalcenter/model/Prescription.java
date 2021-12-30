package com.pjatk.medicalcenter.model;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
public class Prescription {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private int accessCode;

    @Column(nullable = false)
    private LocalDate expiryDate;

    @Column(nullable = false)
    private LocalDate creationDate;

    @ManyToOne(optional = false)
    @Setter(AccessLevel.NONE)
    private Patient patient;

    @ManyToOne
    @JoinColumn(name = "appointment_id", referencedColumnName = "id")
    @Setter(AccessLevel.NONE)
    private Appointment appointment;

    @OneToMany(mappedBy = "prescription", cascade = CascadeType.PERSIST)
    private List<PrescriptionMedication> prescriptionMedications = new ArrayList<>();

    public Prescription() {
        setCreationDate(LocalDate.now());
    }

    public void addPrescriptionMedication(PrescriptionMedication prescriptionMedication) {
        prescriptionMedications.add(prescriptionMedication);
    }

    public void setAppointment(Appointment appointment) {
        this.appointment = appointment;
        appointment.addPrescription(this);
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
        patient.addPrescription(this);
    }
}
