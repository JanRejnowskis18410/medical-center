package com.pjatk.medicalcenter.security.repo;

import com.pjatk.medicalcenter.security.model.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<AppUser, Long> {
    AppUser findAppUserByEmail(String emial);
}
