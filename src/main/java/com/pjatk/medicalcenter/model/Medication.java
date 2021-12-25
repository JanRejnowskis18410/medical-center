package com.pjatk.medicalcenter.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import lombok.*;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

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

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Unit unit;

    @Column(nullable = false)
    private double payment;

    @Column(nullable = false)
    private int quantity;

    public void addPrescriptionMedication(PrescriptionMedication prescriptionMedication) {
        prescriptionMedications.add(prescriptionMedication);
    }
}
