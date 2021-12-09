package com.pjatk.medicalcenter.model;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
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
    @NotNull(message = "First name required")
    private String firstName;

    @Column(name = "lastName", nullable = false)
    @NotNull(message = "Last name required")
    private String lastName;

    @Column(name = "email",unique = true, nullable = false)
    @NotNull(message = "Email required")
    @Email(message = "Email is not valid",
            regexp = "^(?=.{1,64}@)[A-Za-z0-9_-]+(\\.[A-Za-z0-9_-]+)*@[^-][A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$")
    private String email;

    private String password;

    @Column(name = "birthDate", nullable = false)
    @NotNull(message = "Birth date required")
    @Past
    private LocalDate birthDate;

    @Column(name = "PESEL",unique = true)
    @NotNull(message = "PESEL required")
    private String pesel;
}
