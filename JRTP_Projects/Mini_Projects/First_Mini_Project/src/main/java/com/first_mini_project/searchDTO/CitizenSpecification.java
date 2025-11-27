package com.first_mini_project.searchDTO;


import com.first_mini_project.entity.CitizenPlane;
import org.springframework.data.jpa.domain.Specification;

import jakarta.persistence.criteria.Predicate;
import org.springframework.data.jpa.domain.Specification;

import java.util.ArrayList;
import java.util.List;

public class CitizenSpecification {

    // dynamic search method implementation
    public static Specification<CitizenPlane> search(Citizen_Search_DTO dto) {

        return (root, query, cb) -> {

            List<Predicate> predicates = new ArrayList<>();

            // PLAN NAME
            if (dto.getCitizenPlaneName() != null && !dto.getCitizenPlaneName().trim().isEmpty()) {
                predicates.add(
                        cb.equal(root.get("citizenPlaneName"), dto.getCitizenPlaneName().trim())
                );
            }

            // PLAN STATUS
            if (dto.getCitizenPlaneStatus() != null && !dto.getCitizenPlaneStatus().trim().isEmpty()) {
                predicates.add(
                        cb.equal(root.get("citizenPlaneStatus"), dto.getCitizenPlaneStatus().trim())
                );
            }

            // GENDER
            if (dto.getCitizenGender() != null && !dto.getCitizenGender().trim().isEmpty()) {
                predicates.add(
                        cb.equal(root.get("citizenGender"), dto.getCitizenGender().trim())
                );
            }

            // START DATE
            if (dto.getStartDate() != null && !dto.getStartDate().trim().isEmpty()) {
                predicates.add(
                        cb.greaterThanOrEqualTo(
                                root.get("citizenPlaneStartDate"),
                                java.sql.Date.valueOf(dto.getStartDate())
                        )
                );
            }

            // END DATE
            if (dto.getEndDate() != null && !dto.getEndDate().trim().isEmpty()) {
                predicates.add(
                        cb.lessThanOrEqualTo(
                                root.get("citizenPlaneEndDate"),
                                java.sql.Date.valueOf(dto.getEndDate())
                        ) 
                );
            }

            return cb.and(predicates.toArray(new Predicate[0]));
        };
    }
}
