package com.second_mini_project.Entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity

@Table(
        name = "user_dtls_table",
        schema = "second_mini_project"

)
public class UserDtlsEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Integer userId;
    @Column(name = "user_name")
    private String userName;
    @Column(name = "user_email", unique = true)
    private String userEmail;
    @Column(name = "user_password")
    private String userPassword;
    @Column(name = "user_phoneno")
    private String userPhoneno;
    @Column(name = "user_acc_status")
    private String userAccStatus;

    @OneToMany(mappedBy = "userDtlsEntity", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<StudentEnqEntity> studentenquiries;



}
