package com.second_mini_project.Services;

import com.second_mini_project.DTO.Add_and_Update_Form;
import com.second_mini_project.DTO.DashboardPerformance;
import com.second_mini_project.DTO.Dashboard_dynamic_serch;
import com.second_mini_project.Entity.StudentEnqEntity;
import jakarta.servlet.http.HttpSession;

import java.util.List;

public interface EnquiryService_inter {

    //get the records based on User_ID
    public DashboardPerformance getEnquiriesByUserId(HttpSession session);

    //Dropdown for Enquiry Status
    public List<String> getEnquiryStatusDropDown();

    //Dropdown for Course Names
    public List<String> getCourseNamesDropDown();

    // add student menthod
    public boolean addNewStudentEnquiry(Add_and_Update_Form from, HttpSession session);

    // update student enquiry method
    public boolean updateStudentEnquiry(Add_and_Update_Form form, HttpSession session);

// search student enquiry method
    public List<StudentEnqEntity> searchStudentEnquiry(Dashboard_dynamic_serch form, HttpSession session);
}