package com.pjatk.medicalcenter.specifications;

import com.pjatk.medicalcenter.model.Appointment;
import org.springframework.data.jpa.domain.Specification;

import java.util.ArrayList;
import java.util.List;

public class AppointmentSpecificationBuilder {

    private List<Specification<Appointment>> specifications = new ArrayList<>();

    public void addSpecification(Specification<Appointment> specification){
        this.specifications.add(specification);
    }

    public Specification<Appointment> build(){
        Specification<Appointment> mergedSpecifications = specifications.get(0);
        for (int i = 1; i < specifications.size(); i++) {
            mergedSpecifications = Specification.where(mergedSpecifications).and(specifications.get(i));
        }
        return mergedSpecifications;
    }
}
