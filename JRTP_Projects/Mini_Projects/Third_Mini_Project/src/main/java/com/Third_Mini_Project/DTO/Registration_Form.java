package com.Third_Mini_Project.DTO;


import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class Registration_Form {

    @NotBlank(message = "First name is required")
    private String F_name;
    @NotBlank(message = "Last name is required")
    private String L_name;
    @Email(message = "Invalid email format")
    @NotBlank(message = "Email is required")
    private String email;
    @NotBlank(message = "Password is required")
    private String password;

}
