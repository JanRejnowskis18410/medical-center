package com.pjatk.medicalcenter.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Patient extends Person{

    @Embedded
    private Address address;

    @Column(name = "phoneNumber")
    private String phoneNumber;

    public Patient(Person person, Address address, String phoneNumber){
        super(person.getFirstName(),person.getLastName(),person.getEmail(),person.getBirthDate(), person.getPesel());
        this.address=address;
        this.phoneNumber=phoneNumber;
    }

}
