package com.Third_Mini_Project.Services;

import com.Third_Mini_Project.DTO.*;
import com.Third_Mini_Project.Entity.Blog;
import com.Third_Mini_Project.Entity.User;
import com.Third_Mini_Project.Repo.Blog_Repo;
import com.Third_Mini_Project.Repo.User_Repo;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import jakarta.servlet.http.HttpSession;
@Service
@RequiredArgsConstructor
public class User_IMP implements  User_Inter {

    @Autowired
    private User_Repo user_repo;

    @Autowired
    private  Blog_Repo blog_repo;

    @Autowired
    private Blog_IMP blog_imp;

    @Override
    public boolean Registration_Service(Registration_Form reg_form) {

        // check if user already exists with the same email
        if (user_repo.findByEmail(reg_form.getEmail()) != null)
            return false;

         // copy data from DTO to Entity and save
        User user = new User();
        BeanUtils.copyProperties(reg_form, user);
        user_repo.save(user);

        return true;
    }

    @Override
    public Login_Response_Form login_Service(Login_Form login_form , HttpSession session) {
        User byEmailAndUserPsw = user_repo.findByEmailAndPassword(login_form.getEmail(), login_form.getPassword());
        Login_Response_Form loginResponcesForm = new Login_Response_Form();
        // check user not exist
        if (byEmailAndUserPsw == null){
            loginResponcesForm.setStatus("FAILED");
            loginResponcesForm.setMessage("Invalid Credentials");
            return loginResponcesForm;
        } else {
            // TODO success login --> modified session code for user performance functionality
            // TODO set session attribute
            // 🔴 IMPORTANT: store logged-in user in session
            session.setAttribute("userID", byEmailAndUserPsw.getUserSno());
            session.setAttribute("userName", byEmailAndUserPsw.getFirstName()); // optional

            loginResponcesForm.setUserName(byEmailAndUserPsw.getFirstName());
            loginResponcesForm.setStatus("SUCCESS");
            loginResponcesForm.setMessage("Login Successful");
            return loginResponcesForm;
        }

    }

    @Override
    public Page<All_Blogs_Reponces_Form> getAllBlogs_Login_User(int page, int size, HttpSession session) {
        // 1️⃣ Get logged-in user ID from session
        Long userId = (Long) session.getAttribute("userID"); // key should match with the one used during login

        if (userId == null) {
            throw  new RuntimeException ("User not logged in");
        }
        // logic for fetching blogs for logged-in user by using blog_imp helper method

        // 2️⃣ Create pageable
        Pageable pageable = PageRequest.of(page, size, Sort.by("blogId").descending());

        // 3️⃣ Fetch ONLY logged-in user's blogs
        Page<Blog> blogPage = blog_repo.findByUser_UserSno(userId, pageable);

        if (blogPage.isEmpty()) {
            return Page.empty(pageable);
        }

        // 4️⃣ Reuse existing helper (BEST PART)
        return blog_imp.mapPageBlogsToDTO(blogPage);


    }

    @Override
    public boolean createBlog_Login_User(Create_Blog_Form createBlogForm, HttpSession session){
        // 1️⃣ Get logged-in user ID from session
        Long userId = (Long) session.getAttribute("userID"); // key should match with the one used during login

        if (userId == null) {
            throw  new RuntimeException ("User not logged in");
        }

        // 2️⃣ Fetch User entity from DB
        User user = user_repo.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));

        // 3️⃣ Create Blog entity and copy data from DTO
        Blog blog = new Blog();
        BeanUtils.copyProperties(createBlogForm, blog);

        // 4️⃣ Set the User entity to establish relationship
        blog.setUser(user);

        // 5️⃣ Save the blog
        blog_repo.save(blog);

        return true;
    }




}
