package com.pjatk.medicalcenter;

import com.pjatk.medicalcenter.security.model.AppRole;
import com.pjatk.medicalcenter.security.model.AppUser;
import com.pjatk.medicalcenter.security.service.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.time.LocalDateTime;

@SpringBootApplication
@EnableScheduling
public class MedicalCenterApplication {

    public static void main(String[] args) {

        SpringApplication.run(MedicalCenterApplication.class, args);
    }

    @Bean
    PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Bean
    CommandLineRunner run(UserService userService) {
        return args -> {
            userService.addUser(new AppUser(1l, "kasia@gmail.com", "Kasia123", AppRole.DOCTOR));
            userService.addUser(new AppUser(2l, "karol@gmail.com", "Karol123", AppRole.PATIENT));
        };
    }


}
