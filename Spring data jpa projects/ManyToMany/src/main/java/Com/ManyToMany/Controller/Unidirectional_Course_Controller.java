package Com.ManyToMany.Controller;

import Com.ManyToMany.Entity.Unidirectional_Course;
import Com.ManyToMany.Entity.Unidirectional_Student;
import Com.ManyToMany.Repository.Unidirectional_Course_Repo;
import Com.ManyToMany.Repository.Unidirectional_Student_Repo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/Course")
public class Unidirectional_Course_Controller {

    @Autowired
    private Unidirectional_Course_Repo unidirectionalCourseRepo;

    @Autowired
    private Unidirectional_Student_Repo unidirectionalStudentRepo;

    // Get all Courses
    @GetMapping("/allCourses")
    public List<Unidirectional_Course> getAllCourses() {
        return unidirectionalCourseRepo.findAll();
    }

/*
    // Get Course details by Student ID
    @GetMapping("/courseByStudent/{studentId}")
    public List<Unidirectional_Course> getCourseByStudentId(@PathVariable Long studentId) {
        return unidirectionalCourseRepo.findById(studentId);  // Find courses by student ID
    }
*/

    // Get Course details by Student ID
    @GetMapping("/coursesByStudent/{studentId}")
    public List<Unidirectional_Course> getCoursesByStudentId(@PathVariable Long studentId) {
        // Fetch the student by ID
        Unidirectional_Student student = unidirectionalStudentRepo.findById(studentId)
                .orElseThrow(() -> new RuntimeException("Student not found"));

        // Return the list of courses associated with the student
        return student.getCourses();
    }
}
