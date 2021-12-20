package com.pjatk.medicalcenter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

import java.time.LocalDateTime;

@SpringBootApplication
@EnableScheduling
public class MedicalCenterApplication {

    public static void main(String[] args) {

        SpringApplication.run(MedicalCenterApplication.class, args);
        System.out.println(LocalDateTime.now());
    }

}
