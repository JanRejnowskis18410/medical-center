package com.pjatk.medicalcenter.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Type;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Medication {

    private enum Unit {
        MILLILITERS, LITERS, GRAMS
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Enumerated(EnumType.STRING)
    private Unit unit;

    @Column(nullable = false)
    private double refund;

    @Column(nullable = false)
    private int quantity;

    @Column(nullable = false)
    @Type(type = "numeric_boolean")
    private boolean extendable;
}
