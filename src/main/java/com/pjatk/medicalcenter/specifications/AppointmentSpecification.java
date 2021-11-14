package com.pjatk.medicalcenter.specifications;

import com.pjatk.medicalcenter.model.Appointment;
import com.pjatk.medicalcenter.model.Doctor;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.*;
import javax.print.Doc;
import java.time.LocalDateTime;

public class AppointmentSpecification {

    public static Specification<Appointment> medicalServiceIdEqualTo(long medicalServiceId){
        return (root, query, criteriaBuilder)
                -> criteriaBuilder.equal(root.get("medicalService"), medicalServiceId);
    }

    public static Specification<Appointment> doctorIdEqualTo(long doctorId){
        return (root, query, criteriaBuilder)
                -> criteriaBuilder.equal(root.get("doctor"), doctorId);
    }

    public static Specification<Appointment> dateGreaterThanOrEqual(LocalDateTime date){
        return (root, query, criteriaBuilder)
                -> criteriaBuilder.greaterThanOrEqualTo(root.get("date"), date);
    }

    public static Specification<Appointment> dateLessThanOrEqual(LocalDateTime date){
        return (root, query, criteriaBuilder)
                -> criteriaBuilder.lessThanOrEqualTo(root.get("date"), date);
    }

    public static Specification<Appointment> languageEqual(Doctor.Language language){
        return (root, criteriaQuery, criteriaBuilder) -> {
            Join<Appointment, Doctor> doctorJoin = root.join("doctor", JoinType.INNER);
            return doctorJoin.join("languages").in(language);
        };
    }
}
