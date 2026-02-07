package com.Third_Mini_Project.Controller;


import com.Third_Mini_Project.DTO.*;
import com.Third_Mini_Project.Repo.Blog_Repo;
import com.Third_Mini_Project.Services.Blog_Inter;
import com.Third_Mini_Project.Services.Comments_IMP;
import com.Third_Mini_Project.Services.Comments_Inter;
import com.Third_Mini_Project.Services.User_Inter;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class User_Controller {

    @Value("${pagination.default-page}")
    private int defaultPage;

    @Value("${pagination.default-size}")
    private int defaultSize;

    @Value("${pagination.max-size}")
    private int maxSize;

    @Autowired
    private User_Inter userService;

    @Autowired
    private Comments_Inter commentsService;

    @Autowired
    private Blog_Inter blogService;

    // save the registration form data
    @PostMapping("/register")
    public ResponseEntity<?> registerUser(@Valid @RequestBody Registration_Form form) {
        boolean data = userService.Registration_Service(form);

        if (!data) {
            return ResponseEntity.badRequest().body("Email already exists kindly use different email");
        } else {
            return ResponseEntity.ok("Account created successfully");
        }
    }

    //login implementation will go here
    @PostMapping("/login")
    public ResponseEntity<?> login(@Valid @RequestBody Login_Form loginForm, HttpSession session) {

        Login_Response_Form Data = userService.login_Service(loginForm, session);

        if ("FAILED".equals(Data.getStatus())) {
            return ResponseEntity.badRequest().body(Data);
        } else {

            return ResponseEntity.ok(Data);
        }


    }

    // get all blogs records for login user

    @GetMapping("/allBlogs")
    public ResponseEntity<?> getAllBlogs(HttpSession session,
                                         @RequestParam(required = false) Integer page,
                                         @RequestParam(required = false) Integer size) {

        int pageNumber = (page != null) ? page : defaultPage;
        int pageSize = (size != null) ? Math.min(size, maxSize) : defaultSize;

        Page<All_Blogs_Reponces_Form> allBlogsLoginUser =
                userService.getAllBlogs_Login_User(pageNumber, pageSize, session);
        if (allBlogsLoginUser.isEmpty()) {
            return ResponseEntity.ok("No blogs available");
        }
        return ResponseEntity.ok(allBlogsLoginUser);

    }
// create blog for login user
    @PostMapping("/createBlog")
    public ResponseEntity<?> createBlogForLoginUser(@Valid @RequestBody Create_Blog_Form createBlogForm,
                                                    HttpSession session) {
        boolean blogCreated = userService.createBlog_Login_User(createBlogForm, session);
        if (blogCreated) {
            return ResponseEntity.ok("Blog created successfully");
        } else {
            return ResponseEntity.badRequest().body("Blog creation failed");
        }

    }

    // comments for login user
    @GetMapping("/comments")
    public ResponseEntity<?> getCommentsForLoginUser(HttpSession session,
                                                     @RequestParam(required = false) Integer page,
                                                     @RequestParam(required = false) Integer size) {

        int pageNumber = (page != null) ? page : defaultPage;
        int pageSize = (size != null) ? Math.min(size, maxSize) : defaultSize;
        Page<Comments_Responce_Form> allBlogsLoginUser =
                commentsService.getCommentsOfLoggedInUser(pageNumber, pageSize, session);
        if (allBlogsLoginUser.isEmpty()) {
            return ResponseEntity.ok("No comments available");
        }else{
            return ResponseEntity.ok(allBlogsLoginUser);
        }
    }


    // delete blog for login user
    @DeleteMapping("/deleteBlog/{blogId}")
    public ResponseEntity<?> deleteBlogForLoginUser(@PathVariable Long blogId, HttpSession session) {
        boolean blogDeleted = blogService.deleteBlogByUserSnoAndBlogId(session, blogId);
        if (blogDeleted) {
            return ResponseEntity.ok("Blog deleted successfully");
        } else {
            return ResponseEntity.badRequest().body("Blog deletion failed");
        }
    }

}