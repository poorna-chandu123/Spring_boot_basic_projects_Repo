package Com.ManyToMany.Controller;

import Com.ManyToMany.Entity.Bidirectional_Course;
import Com.ManyToMany.Entity.Bidirectional_Student;
import Com.ManyToMany.Repository.Bidirectional_Course_Repo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController
@RequestMapping("/BICourse")
public class Bidirectional_Course_Controller {

    @Autowired
    private Bidirectional_Course_Repo bidirectionalCourseRepo;

    // Get all courses
    @GetMapping("/allCourses")
    public List<Bidirectional_Course> getAllCourses() {
        return bidirectionalCourseRepo.findAll();
    }

    // Get Student details by Course ID
    @GetMapping("/studentsByCourse/{courseId}")
    public List<Bidirectional_Student> getStudentsByCourseId(@PathVariable Long courseId) {
        // Fetch the course by ID
        Bidirectional_Course course = bidirectionalCourseRepo.findById(courseId)
                .orElseThrow(() -> new RuntimeException("Course not found"));

        // Return the list of students associated with the course
        return course.getStudents();
    }

}
