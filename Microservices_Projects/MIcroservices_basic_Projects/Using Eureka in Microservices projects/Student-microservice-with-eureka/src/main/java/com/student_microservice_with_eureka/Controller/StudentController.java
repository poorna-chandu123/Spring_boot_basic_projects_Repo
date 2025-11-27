package com.student_microservice_with_eureka.Controller;



import com.student_microservice_with_eureka.Request.CreateStudentRequest;
import com.student_microservice_with_eureka.Responces.StudentResponse;
import com.student_microservice_with_eureka.Services.StudentService_I;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/student")
public class StudentController {

    @Autowired
    StudentService_I studentService;

    @PostMapping("/createstudent")
    public StudentResponse createStudent (@RequestBody CreateStudentRequest createStudentRequest) {
        return studentService.createStudent(createStudentRequest);
    }

    @GetMapping("getById/{id}")
    public StudentResponse getById (@PathVariable long id) {
        return studentService.getById(id);
    }

}