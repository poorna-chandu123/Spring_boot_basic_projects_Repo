package com.Student_microservice_API_GateWay.Repository;

import com.Student_microservice_API_GateWay.Entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;


public interface StudentRepository extends JpaRepository<Student, Long> {
}
