package com.second_mini_project.Utils;

import com.second_mini_project.DTO.Dashboard_dynamic_serch;
import com.second_mini_project.Entity.StudentEnqEntity;
import jakarta.persistence.criteria.Predicate;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;

import java.util.ArrayList;
import java.util.List;

public class Dashboard_dynamic_serch_Util {

// dynamic search util class
    // requirement  : if user not select any field  -> i need to display all the records
    // if user select any field  -> i need to filter based on that field
  // Note :  this method i will call from services class
    public static Specification<StudentEnqEntity> getSearchQuery(Dashboard_dynamic_serch dashboard_dynamic_serch ) {

        return (root, query, cb) -> {
            List<Predicate> predicates = new ArrayList<>();

            // check for course
            if (dashboard_dynamic_serch.getCourse() != null && !dashboard_dynamic_serch.getCourse().isEmpty()) {
                predicates.add(cb.equal(root.get("studentCourse"), dashboard_dynamic_serch.getCourse()));
            }
            // check for class mode
            if (dashboard_dynamic_serch.getClassMode() != null && !dashboard_dynamic_serch.getClassMode().isEmpty()) {
                predicates.add(cb.equal(root.get("studentClassMode"), dashboard_dynamic_serch.getClassMode()));
            }
            // check for enquiry status
            if (dashboard_dynamic_serch.getEnquiryStatus() != null && !dashboard_dynamic_serch.getEnquiryStatus().isEmpty()) {
                predicates.add(cb.equal(root.get("studentEnqStatus"), dashboard_dynamic_serch.getEnquiryStatus()));
            }
            return cb.and(predicates.toArray(new Predicate[0]));
        };

    }
}
