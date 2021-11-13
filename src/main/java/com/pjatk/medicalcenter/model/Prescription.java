package com.pjatk.medicalcenter.model;

import jakarta.validation.constraints.Future;
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
    @Future
    private LocalDate dateToUse;

    @Column(nullable = false)
    private LocalDate creationDate;

    @OneToMany(mappedBy = "prescription")
    private List<PrescriptionMedication> prescriptionMedications = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name = "appointment_id", referencedColumnName = "id")
    @Setter(AccessLevel.NONE)
    private Appointment appointment;

    @Lob
    @Column(columnDefinition = "BLOB", nullable = false)
    private byte[] binaryCode;

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
}
