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

    @Column(name="street", nullable = false, length = 50)
    private String street;

    @Column(name="streetNumber", nullable = false, length = 10)
    private String streetNumber;

    @Column(name="postCode", nullable = false, length = 10)
    private String postCode;

    @Column(name="city", nullable = false, length = 50)
    private String city;

    @Column(name="country", nullable = false, length = 50)
    private String country;
}
