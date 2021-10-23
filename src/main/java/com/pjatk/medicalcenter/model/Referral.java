package com.pjatk.medicalcenter.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@NoArgsConstructor
@Data
public class Referral {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(
            nullable = false
    )
    private LocalDate issueDate;

    @Column(
            nullable = false
    )
    private LocalDate expiryDate;

    @OneToOne
    private Appointment appointment;

    @ManyToOne(optional = false)
    private Appointment issueAppointment;

    @ManyToOne(optional = false)
    private Service service;

    @ManyToOne(optional = false)
    private Patient patient;
}
