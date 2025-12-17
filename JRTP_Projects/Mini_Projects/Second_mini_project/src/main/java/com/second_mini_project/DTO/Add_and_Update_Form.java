package com.second_mini_project.DTO;


import com.second_mini_project.Entity.UserDtlsEntity;
import jakarta.persistence.*;
import lombok.Data;

@Data
public class Add_and_Update_Form {

    private Integer studentId;
    private String studentName;
    private String studentPhno;
    private String studentClassMode;
    private String studentCourse;
    private String studentEnqStatus;


}
