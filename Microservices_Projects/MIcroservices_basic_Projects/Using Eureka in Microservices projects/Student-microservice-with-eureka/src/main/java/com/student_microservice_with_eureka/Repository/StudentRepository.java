package com.student_microservice_with_eureka.Repository;

import com.student_microservice_with_eureka.Entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;


public interface StudentRepository extends JpaRepository<Student, Long> {
}
