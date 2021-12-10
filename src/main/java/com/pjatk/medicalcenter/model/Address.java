package com.pjatk.medicalcenter.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Address {

    @Column(name="street", nullable = false)
    private String street;

    @Column(name="streetNumber", nullable = false)
    private String streetNumber;

    @Column(name="postCode", nullable = false)
    private String postCode;

    @Column(name="city", nullable = false)
    private String city;

    @Column(name="country", nullable = false)
    private String country;
}
