package com.Microservices_basic_Stu.Controller;


import com.Microservices_basic_Stu.Request.CreateStudentRequest;
import com.Microservices_basic_Stu.Responces.StudentResponse;
import com.Microservices_basic_Stu.Services.StudentService_I;
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