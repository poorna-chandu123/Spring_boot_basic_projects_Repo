package com.student_circuit_breaker.Repository;

import com.student_circuit_breaker.Entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;


public interface StudentRepository extends JpaRepository<Student, Long> {
}
