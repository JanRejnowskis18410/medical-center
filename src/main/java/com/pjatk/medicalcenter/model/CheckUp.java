package com.pjatk.medicalcenter.model;

import lombok.*;

import javax.persistence.*;

@Entity
@Data
public class CheckUp {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

}
