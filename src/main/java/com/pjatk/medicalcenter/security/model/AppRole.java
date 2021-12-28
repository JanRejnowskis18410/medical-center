package com.pjatk.medicalcenter.security.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum AppRole {
    DOCTOR("DOCTOR"),
    PATIENT("PATIENT");

    private final String name;
}
