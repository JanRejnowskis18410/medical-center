package com.pjatk.medicalcenter.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import lombok.*;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.stream.Stream;

@Entity
@Data
public class Medication {

    public enum Unit {

        MILLILITERS("ML"), LITERS("L"), GRAMS("G"), MILLIGRAMS("MG");

        private String code;

        Unit(String code) {
            this.code = code;
        }

        @JsonCreator
        public static Unit decode(final String code) {
            return Stream.of(Unit.values()).filter(targetEnum -> targetEnum.code.equals(code)).findFirst().orElse(null);
        }

        @JsonValue
        public String getCode() {
            return code;
        }
    }

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

    @Column(nullable = false)
    @Type(type = "numeric_boolean")
    private boolean extendable;
}
