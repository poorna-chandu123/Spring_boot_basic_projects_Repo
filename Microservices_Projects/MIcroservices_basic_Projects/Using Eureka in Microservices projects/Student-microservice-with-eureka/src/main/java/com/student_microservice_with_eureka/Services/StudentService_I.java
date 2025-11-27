package com.student_microservice_with_eureka.Services;


import com.student_microservice_with_eureka.Request.CreateStudentRequest;
import com.student_microservice_with_eureka.Responces.StudentResponse;

public interface StudentService_I {

    public StudentResponse createStudent(CreateStudentRequest createStudentRequest);

    public StudentResponse getById (long id);

}
