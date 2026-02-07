package com.Third_Mini_Project.Controller;


import com.Third_Mini_Project.DTO.Comments_Form;
import com.Third_Mini_Project.Services.Comments_IMP;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/comments")
public class Comments_Controller {

    @Autowired
    private Comments_IMP commentsService;

    // Add methods to handle comments-related requests here
    @PostMapping("/add" )
    public ResponseEntity<?> addComment(@Valid @RequestBody Comments_Form form) {
        commentsService.Add_Comments(form);
       if (form == null) {
           return ResponseEntity.badRequest().body("Failed to add comment");
       }else{
              return ResponseEntity.ok("Comment added successfully");
       }
    }


}
