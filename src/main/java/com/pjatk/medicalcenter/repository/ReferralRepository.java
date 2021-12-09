package com.pjatk.medicalcenter.repository;

import com.pjatk.medicalcenter.model.Referral;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface ReferralRepository extends JpaRepository<Referral, Long> {

    public List<Referral> findByPatientIdAndAppointmentIsNullAndExpiryDateGreaterThanEqual(Long id, LocalDate now);
}
