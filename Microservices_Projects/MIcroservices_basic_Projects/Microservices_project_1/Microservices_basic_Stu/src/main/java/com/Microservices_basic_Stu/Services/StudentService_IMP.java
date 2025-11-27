package com.Microservices_basic_Stu.Services;

import com.Microservices_basic_Stu.Entity.Student;
import com.Microservices_basic_Stu.FeignClient.AddressFeignClient;
import com.Microservices_basic_Stu.Repository.StudentRepository;
import com.Microservices_basic_Stu.Request.CreateStudentRequest;
import com.Microservices_basic_Stu.Responces.StudentResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class StudentService_IMP implements StudentService_I{
    @Autowired
    StudentRepository studentRepository;
    @Autowired
    AddressFeignClient addressFeignClient;


    @Override
    public StudentResponse createStudent(CreateStudentRequest createStudentRequest) {

        Student student = new Student();
        student.setFirstName(createStudentRequest.getFirstName());
        student.setLastName(createStudentRequest.getLastName());
        student.setEmail(createStudentRequest.getEmail());
        student.setAddressId(createStudentRequest.getAddressId());

        student = studentRepository.save(student);

        StudentResponse studentResponse = new StudentResponse(student);

        studentResponse.setAddressResponse(addressFeignClient.getById(student.getAddressId()));

        return studentResponse;
    }

    @Override
    public StudentResponse getById (long id) {

        Student student = studentRepository.findById(id).get();
        StudentResponse studentResponse = new StudentResponse(student);

        studentResponse.setAddressResponse(addressFeignClient.getById(student.getAddressId()));

        return studentResponse;
    }
}
