package com.pjatk.medicalcenter.model;

import lombok.Data;

import javax.persistence.Embeddable;

@Embeddable
@Data
public class Address {

    private String street;
    private String streetNumber;
    private String postCode;
    private String city;
    private String country;

}
