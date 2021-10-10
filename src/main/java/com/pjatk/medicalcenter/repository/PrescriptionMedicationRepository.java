package com.pjatk.medicalcenter.repository;

import com.pjatk.medicalcenter.model.PrescriptionMedication;
import com.pjatk.medicalcenter.model.PrescriptionMedicationId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PrescriptionMedicationRepository extends JpaRepository<PrescriptionMedication, PrescriptionMedicationId> {

}
