package com.pjatk.medicalcenter.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "firstName", nullable = false, length = 50)
    private String firstName;

    @Column(name = "lastName", nullable = false, length = 50)
    private String lastName;

    @Column(name = "email",unique = true, nullable = false, length = 100)
    private String email;

    private String password;

    @Column(name = "birthDate", nullable = false)
    private LocalDate birthDate;

    @Column(name = "PESEL",unique = true, length = 11)
    private String pesel;
}
