package com.pjatk.medicalcenter.specifications;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class SearchCriteria {
    private String key;
    private SearchOperation searchOperation;
    private boolean isOrOperation;
    private List<Object> arguments;
}

enum SearchOperation {
    EQUALS, GREATER_THEN_OR_EQUAL, LESS_THEN_OR_EQUAL, IN
}
