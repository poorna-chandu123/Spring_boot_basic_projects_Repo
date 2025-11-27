package com.Student_LoadBalancer_Project.Services;



import com.Student_LoadBalancer_Project.Entity.Student;
import com.Student_LoadBalancer_Project.FeignClient.AddressFeignClient;
import com.Student_LoadBalancer_Project.Repository.StudentRepository;
import com.Student_LoadBalancer_Project.Request.CreateStudentRequest;
import com.Student_LoadBalancer_Project.Responces.StudentResponse;
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
