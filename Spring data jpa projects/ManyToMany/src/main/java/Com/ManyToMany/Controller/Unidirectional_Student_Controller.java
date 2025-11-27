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
@RequestMapping("/Student")
public class Unidirectional_Student_Controller {

    @Autowired
    private Unidirectional_Student_Repo unidirectionalStudentRepo;

    @Autowired
    private Unidirectional_Course_Repo unidirectionalCourseRepo;

    // Get all students
    @GetMapping("/allStudents")
    public List<Unidirectional_Student> getAllStudents() {
        return unidirectionalStudentRepo.findAll();
    }

/*   // Get Student details by Course ID
    @GetMapping("/studentByCourse/{courseId}")
    public Unidirectional_Student getStudentByCourseId(@PathVariable Long courseId) {
        Unidirectional_Course course = unidirectionalCourseRepo.findById(courseId)
                .orElseThrow(() -> new RuntimeException("Course not found"));
        return course.getStudent();  // Get student from the Course entity
    } */
}
