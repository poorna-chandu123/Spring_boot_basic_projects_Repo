package com.second_mini_project.DTO;


import lombok.Data;

@Data
public class SignUp_Responces {

    // not used yet because i am just retuning the string message : not a JSON response in case
    // if i need to return JSON response then i will use this DTO class

    private String userName;
    private String userEmail;
    private String userPhoneno;
}
