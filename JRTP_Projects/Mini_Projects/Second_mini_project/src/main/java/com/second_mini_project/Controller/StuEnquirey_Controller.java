package com.second_mini_project.Controller;


import com.second_mini_project.DTO.Add_and_Update_Form;
import com.second_mini_project.DTO.DashboardPerformance;
import com.second_mini_project.DTO.Dashboard_dynamic_serch;
import com.second_mini_project.Entity.StudentEnqEntity;
import com.second_mini_project.Repo.CourseRepo;
import com.second_mini_project.Repo.EnqStatusRepo;
import com.second_mini_project.Repo.StudentEnqRepo;
import com.second_mini_project.Services.EnquiryService_inter;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.graphql.GraphQlProperties;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/enquiry")
public class StuEnquirey_Controller {

    @Autowired
    private EnquiryService_inter enquiryService;


    // get mapping for distant Enquiry status
    @GetMapping("/distinctStatus")
    public List<String> getDistinctEnqStatusNames() {
        return enquiryService.getEnquiryStatusDropDown();
    }

    // get mapping for distinct course names
    @GetMapping("/distinctCourse")
    public List<String> getDistinctCourseNames() {
        return enquiryService.getCourseNamesDropDown();
    }

    // other methods related to student enquiries can be added here
    @PostMapping("/AddStudent")
    public ResponseEntity<?> addStudentEnquiry(@RequestBody Add_and_Update_Form form, HttpSession session) {

        boolean b = enquiryService.addNewStudentEnquiry(form, session);

        if (!b) {
            return ResponseEntity.badRequest().body("Failed to add student enquiry");
        }

        return ResponseEntity.ok("Student enquiry added successfully");

    }

    // get Performance Dashboard Data
    @GetMapping("/dashboard")
    public ResponseEntity<?> getDashboardData(HttpSession session) {

        DashboardPerformance enquiriesByUserId = enquiryService.getEnquiriesByUserId(session);

        return ResponseEntity.ok(enquiriesByUserId);

    }

    // update student enquiry
    @PostMapping("/updateStudent")
    public ResponseEntity<?> updateStudentEnquiry(@RequestBody Add_and_Update_Form form, HttpSession session) {

        boolean b = enquiryService.updateStudentEnquiry(form, session);

        if (!b) {
            return ResponseEntity.badRequest().body("Failed to update student enquiry");
        }
        return ResponseEntity.ok("Student enquiry updated successfully");

    }

    // search student enquiry
    @PostMapping("/searchStudent")
    public ResponseEntity<?> searchStudentEnquiry(@RequestBody Dashboard_dynamic_serch form, HttpSession session) {
        List<StudentEnqEntity> result = enquiryService.searchStudentEnquiry(form, session);
        if (result.isEmpty()) {
            return ResponseEntity.badRequest().body("No matching student enquiries found");
        }
        return ResponseEntity.ok(result);
    }

}
