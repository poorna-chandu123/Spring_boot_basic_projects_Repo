package com.Student_microservice_API_GateWay.Services;


import com.Student_microservice_API_GateWay.Request.CreateStudentRequest;
import com.Student_microservice_API_GateWay.Responces.StudentResponse;

public interface StudentService_I {

    public StudentResponse createStudent(CreateStudentRequest createStudentRequest);

    public StudentResponse getById (long id);

}
