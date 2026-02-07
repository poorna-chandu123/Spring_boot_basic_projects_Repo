package com.Third_Mini_Project.DTO;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

import java.time.LocalDateTime;


@Data
public class Comments_Responce_Form {


    private String email;

    private String comment;

    private LocalDateTime createdAt;

}
