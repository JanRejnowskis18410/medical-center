package com.pjatk.medicalcenter.repository;

import com.pjatk.medicalcenter.model.MedicalService;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ServiceRepository extends JpaRepository<MedicalService, Long> {
}
