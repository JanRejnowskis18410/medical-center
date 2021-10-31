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
    EQUALITY, NEGATION, GREATER_THAN, LESS_THAN, LIKE, STARTS_WITH, IN
}
