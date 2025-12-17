package com.second_mini_project.DTO;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class UnlockForm_with_Global_Exception {

    @Email(message = "Invalid email format")
    @NotBlank(message = "Email is required")
    private String userEmail;

    @NotBlank(message = "Temporary password is required")
    private String tempPsw;

    @NotBlank(message = "New password is required")
    private String newPsw;

    @NotBlank(message = "Confirm password is required")
    private String confirmPsw;
}
