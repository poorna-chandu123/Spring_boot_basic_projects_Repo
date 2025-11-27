package com.student_circuit_breaker.Services;





import com.student_circuit_breaker.Entity.Student;
import com.student_circuit_breaker.FeignClient.AddressFeignClient;
import com.student_circuit_breaker.Repository.StudentRepository;
import com.student_circuit_breaker.Request.CreateStudentRequest;
import com.student_circuit_breaker.Responces.StudentResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class StudentService_IMP implements StudentService_I{
    @Autowired
    StudentRepository studentRepository;


    @Autowired
    CommonService commonService;


    @Override
    public StudentResponse createStudent(CreateStudentRequest createStudentRequest) {

        Student student = new Student();
        student.setFirstName(createStudentRequest.getFirstName());
        student.setLastName(createStudentRequest.getLastName());
        student.setEmail(createStudentRequest.getEmail());
        student.setAddressId(createStudentRequest.getAddressId());

        student = studentRepository.save(student);

        StudentResponse studentResponse = new StudentResponse(student);

       // studentResponse.setAddressResponse(addressFeignClient.getById(student.getAddressId()));
        studentResponse.setAddressResponse(commonService.getAddressByIdCommonService(student.getAddressId()));
        return studentResponse;
    }

    @Override
    public StudentResponse getById (long id) {

        Student student = studentRepository.findById(id).get();
        StudentResponse studentResponse = new StudentResponse(student);

       // studentResponse.setAddressResponse(addressFeignClient.getById(student.getAddressId()));
        studentResponse.setAddressResponse(commonService.getAddressByIdCommonService(student.getAddressId()));
        return studentResponse;
    }
}
