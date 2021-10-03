package com.pjatk.medicalcenter.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Data
@NoArgsConstructor
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "firstName")
    private String firstName;

    @Column(name = "lastName")
    private String lastName;

    @Column(name = "email",unique = true)
    private String email;

    @Column(name = "birthDate")
    private LocalDate birthDate;

    @Column(name = "PESEL",unique = true)
    private String pesel;

    public Person(String firstName, String lastName, String email, LocalDate birthDate, String pesel) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.birthDate = birthDate;
        this.pesel = pesel;
    }
}
