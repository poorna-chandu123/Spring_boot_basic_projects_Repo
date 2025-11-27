package Com.ManyToMany.Controller;

import Com.ManyToMany.Entity.Bidirectional_Course;
import Com.ManyToMany.Entity.Bidirectional_Student;
import Com.ManyToMany.Repository.Bidirectional_Student_Repo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/BIStudent")
public class Bidirectional_Student_Controller {

    @Autowired
    private Bidirectional_Student_Repo bidirectionalStudentRepo;

    // Get all students
    @GetMapping("/allStudents")
    public List<Bidirectional_Student> getAllStudents() {
        return bidirectionalStudentRepo.findAll();
    }


    // Get Course details by Student ID
    @GetMapping("/coursesByStudent/{studentId}")
    public List<Bidirectional_Course> getCoursesByStudentId(@PathVariable Long studentId) {
        // Fetch the student by ID
        Bidirectional_Student student = bidirectionalStudentRepo.findById(studentId)
                .orElseThrow(() -> new RuntimeException("Student not found"));

        // Return the list of courses associated with the student
        return student.getCourses();
    }


}
