package com.pjatk.medicalcenter.model;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
public class Medication {

    public enum Unit {
        MILLILITERS, LITERS, GRAMS, MILLIGRAMS, PILL
    }

    @OneToMany(mappedBy = "medication")
    private List<PrescriptionMedication> prescriptionMedications = new ArrayList<>();

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 50)
    private String name;

    @Column(nullable = false, length = 50)
    @Enumerated(EnumType.STRING)
    private Unit unit;

    @Column(nullable = false)
    private int quantity;

    public void addPrescriptionMedication(PrescriptionMedication prescriptionMedication) {
        prescriptionMedications.add(prescriptionMedication);
    }
}
