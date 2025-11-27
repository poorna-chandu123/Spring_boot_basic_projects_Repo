package com.Microservices_basic_Stu.Repository;

import com.Microservices_basic_Stu.Entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;


public interface StudentRepository extends JpaRepository<Student, Long> {
}
