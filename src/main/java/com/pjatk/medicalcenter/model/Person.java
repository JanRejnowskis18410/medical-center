package com.pjatk.medicalcenter.model;

import com.pjatk.medicalcenter.security.model.AppUser;
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

    @Column(name = "firstName", nullable = false)
    private String firstName;

    @Column(name = "lastName", nullable = false)
    private String lastName;

    @Column(name = "birthDate", nullable = false)
    private LocalDate birthDate;

    @Column(name = "PESEL",unique = true)
    private String pesel;

    @OneToOne(mappedBy = "person", cascade = CascadeType.ALL)
    private AppUser user;
}
