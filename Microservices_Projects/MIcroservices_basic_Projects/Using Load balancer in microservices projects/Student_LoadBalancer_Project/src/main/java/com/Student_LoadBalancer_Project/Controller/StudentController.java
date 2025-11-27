package com.Student_LoadBalancer_Project.Controller;




import com.Student_LoadBalancer_Project.Request.CreateStudentRequest;
import com.Student_LoadBalancer_Project.Responces.StudentResponse;
import com.Student_LoadBalancer_Project.Services.StudentService_I;
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