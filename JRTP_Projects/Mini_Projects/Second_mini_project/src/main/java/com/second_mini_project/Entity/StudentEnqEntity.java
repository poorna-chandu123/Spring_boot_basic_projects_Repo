package com.second_mini_project.Entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity

@Table(
        name = "student_enq_table",
        schema = "second_mini_project"

)
public class StudentEnqEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "student_id")
    private Integer studentId;
    @Column(name = "student_name")
    private String studentName;
    @Column(name="studdent_phno")
    private String studentPhno;
    @Column(name = "studnet_class_mode")
    private String studentClassMode;
    @Column(name = "student_course")
    private String studentCourse;
    @Column(name="student_enq_status")
    private String studentEnqStatus;
    @Column(name="student_created_date")
    private Date studentCreatedDate;
    @Column(name="student_updated_date")
    private Date studentUpdatedDate;

    @ManyToOne
    @JoinColumn(name = "user_id")
    @JsonIgnore
    private UserDtlsEntity userDtlsEntity;



}
