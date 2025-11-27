package com.Student_microservice_API_GateWay.Controller;





import com.Student_microservice_API_GateWay.Request.CreateStudentRequest;
import com.Student_microservice_API_GateWay.Responces.StudentResponse;
import com.Student_microservice_API_GateWay.Services.StudentService_I;
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