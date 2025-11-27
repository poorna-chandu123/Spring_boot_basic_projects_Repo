package com.Microservices_basic_Stu.Services;

import com.Microservices_basic_Stu.Request.CreateStudentRequest;
import com.Microservices_basic_Stu.Responces.StudentResponse;

public interface StudentService_I {

    public StudentResponse createStudent(CreateStudentRequest createStudentRequest);

    public StudentResponse getById (long id);

}
