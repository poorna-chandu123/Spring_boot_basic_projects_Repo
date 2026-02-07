package com.Third_Mini_Project.Services;

import com.Third_Mini_Project.DTO.*;
import jakarta.servlet.http.HttpSession;
import org.springframework.data.domain.Page;

public interface User_Inter {

    public boolean Registration_Service(Registration_Form reg_form);

    public Login_Response_Form login_Service(Login_Form login_form , HttpSession session);

    public Page<All_Blogs_Reponces_Form> getAllBlogs_Login_User(int page, int size, HttpSession session);

    public boolean createBlog_Login_User(Create_Blog_Form createBlogForm, HttpSession session);
}
