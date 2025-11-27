package com.Student_LoadBalancer_Project.Services;


import com.Student_LoadBalancer_Project.Request.CreateStudentRequest;
import com.Student_LoadBalancer_Project.Responces.StudentResponse;

public interface StudentService_I {

    public StudentResponse createStudent(CreateStudentRequest createStudentRequest);

    public StudentResponse getById (long id);

}
