package com.pjatk.medicalcenter.specifications;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

import java.util.Collections;

@Component
public class SpecificationFactory<T> {

    public Specification<T> isEqual(String key, Object arg) {
        GenericSpecificationsBuilder<T> builder = new GenericSpecificationsBuilder<>();
        return builder.with(key, SearchOperation.EQUALS, Collections.singletonList(arg)).build();
    }

    public Specification<T> isIn(String key, Object arg) {
        GenericSpecificationsBuilder<T> builder = new GenericSpecificationsBuilder<>();
        return builder.with(key, SearchOperation.IN, Collections.singletonList(arg)).build();
    }

    public Specification<T> isLessThanOrEqualTo(String key, Object arg) {
        GenericSpecificationsBuilder<T> builder = new GenericSpecificationsBuilder<>();
        return builder.with(key, SearchOperation.LESS_THEN_OR_EQUAL, Collections.singletonList(arg)).build();
    }

    public Specification<T> isGreaterThanOrEqualTo(String key, Object arg) {
        GenericSpecificationsBuilder<T> builder = new GenericSpecificationsBuilder<>();
        return builder.with(key, SearchOperation.GREATER_THEN_OR_EQUAL, Collections.singletonList(arg)).build();
    }
}
