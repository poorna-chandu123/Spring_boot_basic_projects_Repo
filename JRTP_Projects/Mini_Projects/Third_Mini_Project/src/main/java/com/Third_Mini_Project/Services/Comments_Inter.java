package com.Third_Mini_Project.Services;

import com.Third_Mini_Project.DTO.Comments_Form;
import com.Third_Mini_Project.DTO.Comments_Responce_Form;
import jakarta.servlet.http.HttpSession;
import org.springframework.data.domain.Page;

public interface Comments_Inter {

    public  boolean Add_Comments(Comments_Form comments_Form);

    public Page<Comments_Responce_Form> getCommentsOfLoggedInUser(
            int page, int size, HttpSession session);

}
