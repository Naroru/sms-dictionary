package com.example.sms_dictionary.common;

import com.example.sms_dictionary.common.searchcriteria.SearchCriteria;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;


@Component
public class SpecificationBuilder<E> {

  @SuppressWarnings({"unchecked, rawtypes"})
  public Specification<E> createSpecification(SearchCriteria searchCriteria) {

    Specification<E> result = Specification.where(null);

    for (SearchCriteria.CriteriaPosition criteriaPosition : searchCriteria.getCriteriaPositions()) {

      Specification<E> specification = (root, query, criteriaBuilder) -> {

        String fieldName = criteriaPosition.getFieldName();

        switch (criteriaPosition.getOperation()) {
          case EQUALS -> {
            return criteriaBuilder.equal(root.get(fieldName), criteriaPosition.getValue());
          }
          case NOT_EQUALS -> {
            return criteriaBuilder.notEqual(root.get(fieldName), criteriaPosition.getValue());
          }
          case GREATER_THAN -> {
            return criteriaBuilder.greaterThan(root.get(fieldName), (Comparable) criteriaPosition.getValue());
          }
          case GREATER_EQUAL -> {
            return criteriaBuilder.greaterThanOrEqualTo(root.get(fieldName), (Comparable) criteriaPosition.getValue());
          }
          case LIKE -> {
            return criteriaBuilder.like(root.get(fieldName), "%" + criteriaPosition.getValue() + "%");
          }
          case LESS_THAN -> {
            return criteriaBuilder.lessThan(root.get(fieldName), (Comparable) criteriaPosition.getValue());
          }
          case LESS_EQUAL_THAN -> {
            return criteriaBuilder.lessThanOrEqualTo(root.get(fieldName), (Comparable) criteriaPosition.getValue());
          }
        }
        return null;
      };
      result = result.and(specification);
    }
    return result;
  }
}
