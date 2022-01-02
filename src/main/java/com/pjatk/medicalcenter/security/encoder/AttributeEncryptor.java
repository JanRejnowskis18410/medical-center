package com.pjatk.medicalcenter.security.encoder;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import javax.persistence.AttributeConverter;

@Component
public class AttributeEncryptor implements AttributeConverter<String, String> {

    private final PasswordEncoder passwordEncoder;

    public AttributeEncryptor(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public String convertToDatabaseColumn(String attribute) {
        return passwordEncoder.encode(attribute);
    }

    @Override
    public String convertToEntityAttribute(String s) {
        return s;
    }
}
