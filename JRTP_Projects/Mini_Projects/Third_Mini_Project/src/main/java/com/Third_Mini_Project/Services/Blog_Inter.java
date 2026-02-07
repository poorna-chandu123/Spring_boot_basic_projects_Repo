package com.Third_Mini_Project.Services;

import com.Third_Mini_Project.DTO.All_Blogs_Reponces_Form;
import jakarta.servlet.http.HttpSession;
import org.springframework.data.domain.Page;

import java.util.List;

public interface Blog_Inter {

    // public List<All_Blogs_Reponces_Form> getAllBlogs();

   public  Page<All_Blogs_Reponces_Form> getAllBlogs_2(int page, int size);


   public Page<All_Blogs_Reponces_Form> searchBlogsByTitle(String title, int page, int size);

   // delete method based on userSno and blogId also it should delete all comments associated with that blog as well
    public boolean deleteBlogByUserSnoAndBlogId(HttpSession httpSession, Long blogId);
}
