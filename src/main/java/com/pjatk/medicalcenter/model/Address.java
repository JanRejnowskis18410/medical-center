package com.pjatk.medicalcenter.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Embeddable;

@Embeddable
@Getter @Setter @NoArgsConstructor
public class Address {

    private String street;
    private String streetNumber;
    private String postCode;
    private String city;
    private String country;

}
