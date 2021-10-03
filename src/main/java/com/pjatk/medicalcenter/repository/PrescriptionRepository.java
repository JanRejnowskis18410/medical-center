package com.pjatk.medicalcenter.repository;

import com.pjatk.medicalcenter.model.Prescription;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PrescriptionRepository extends JpaRepository<Prescription, Long> {
}
