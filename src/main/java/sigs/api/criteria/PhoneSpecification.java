package sigs.api.criteria;

import org.apache.commons.lang3.StringUtils;
import org.springframework.data.jpa.domain.Specification;
import sigs.api.model.Phone;

import javax.persistence.criteria.Predicate;

public class PhoneSpecification {

    public static Specification<Phone> filterPhone(String phoneBrand, String phoneName) {
        return (root, query, criteriaBuilder) -> {
            Predicate brandPredicate =
                    criteriaBuilder.like(root.get("phoneBrand"), StringUtils.isBlank(phoneBrand)
                            ? likePattern("") : phoneBrand);
            Predicate namePredicate =
                    criteriaBuilder.like(root.get("phoneName"), StringUtils.isBlank(phoneName)
                            ? likePattern("") : phoneName);
            return criteriaBuilder.and(namePredicate, brandPredicate);
        };
    }

    private static String likePattern(String value) {
        return "%" + value + "%";
    }
}
