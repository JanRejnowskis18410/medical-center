package com.pjatk.medicalcenter.specifications;

import com.pjatk.medicalcenter.model.Appointment;
import com.pjatk.medicalcenter.model.Doctor;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.*;
import java.util.List;

public class GenericSpecification<T> implements Specification<T> {

    private SearchCriteria searchCriteria;

    public GenericSpecification(SearchCriteria searchCriteria) {
        super();
        this.searchCriteria = searchCriteria;
    }

    @Override
    public Predicate toPredicate(Root<T> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
        List<Object> arguments = searchCriteria.getArguments();
        Object arg = arguments.get(0);

//        Join<Appointment, Doctor> doctorJoin = root.join("doctors", JoinType.INNER);

        switch (searchCriteria.getSearchOperation()) {
            case EQUALS:
                return criteriaBuilder.equal(root.get(searchCriteria.getKey()), arg);
            case GREATER_THEN_OR_EQUAL:
                return criteriaBuilder.greaterThan(root.get(searchCriteria.getKey()), (Comparable) arg);
            case LESS_THEN_OR_EQUAL:
                return criteriaBuilder.lessThan(root.get(searchCriteria.getKey()), (Comparable) arg);
//            case IN:
//                return root.get(searchCriteria.getKey()).in(doctorJoin.get("languages"));
        }
        return null;
    }
}
