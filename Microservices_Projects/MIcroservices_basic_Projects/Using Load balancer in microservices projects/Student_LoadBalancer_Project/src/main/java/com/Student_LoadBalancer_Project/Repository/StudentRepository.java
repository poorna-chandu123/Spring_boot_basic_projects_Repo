package com.Student_LoadBalancer_Project.Repository;

import com.Student_LoadBalancer_Project.Entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;


public interface StudentRepository extends JpaRepository<Student, Long> {
}
