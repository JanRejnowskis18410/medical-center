package com.pjatk.medicalcenter.repository;

import com.pjatk.medicalcenter.model.CheckUp;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CheckUpRepository extends JpaRepository<CheckUp, Long> {

}
