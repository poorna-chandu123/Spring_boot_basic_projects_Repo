package com.Third_Mini_Project.DTO;


import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class Create_Blog_Form {

    @NotBlank(message = "Title is required")
    private String title;

    @NotBlank(message = "Short description is required")
    private String shortDescription;

    @NotBlank(message = "Content is required")
    private String content;


}
