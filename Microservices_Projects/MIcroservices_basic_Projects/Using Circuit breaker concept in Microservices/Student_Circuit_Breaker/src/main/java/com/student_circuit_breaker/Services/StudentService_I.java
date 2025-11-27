package com.student_circuit_breaker.Services;


import com.student_circuit_breaker.Request.CreateStudentRequest;
import com.student_circuit_breaker.Responces.StudentResponse;

public interface StudentService_I {

    public StudentResponse createStudent(CreateStudentRequest createStudentRequest);

    public StudentResponse getById (long id);

}
