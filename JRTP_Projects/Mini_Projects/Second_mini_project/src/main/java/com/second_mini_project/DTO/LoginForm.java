package com.second_mini_project.DTO;


import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class LoginForm {

    @Email(message = "Invalid email format")
    @NotBlank(message = "Email is required")
    private String userEmail;

    @NotBlank(message = "password is required")
    private String userPsw;


}
