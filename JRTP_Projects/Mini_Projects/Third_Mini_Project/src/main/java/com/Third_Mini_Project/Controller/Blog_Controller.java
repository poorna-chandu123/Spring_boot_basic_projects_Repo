package com.Third_Mini_Project.Controller;


import com.Third_Mini_Project.DTO.All_Blogs_Reponces_Form;
import com.Third_Mini_Project.Services.Blog_Inter;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping ("/blog")
@RequiredArgsConstructor

public class Blog_Controller {

    @Value("${pagination.default-page}")
    private int defaultPage;

    @Value("${pagination.default-size}")
    private int defaultSize;

    @Value("${pagination.max-size}")
    private int maxSize;

    @Autowired
    private Blog_Inter blogInter;

/*
    @GetMapping("/all")
    public ResponseEntity<List<All_Blogs_Reponces_Form>> getAllBlogs() {
        List<All_Blogs_Reponces_Form> blogs = blogInter.getAllBlogs();
        return ResponseEntity.ok(blogs);
    }
*/

    @GetMapping("/all")
    public ResponseEntity<Page<All_Blogs_Reponces_Form>> getAllBlogs(
            @RequestParam(required = false) Integer page,
            @RequestParam(required = false) Integer size) {

        int pageNumber = (page != null) ? page : defaultPage;
        int pageSize = (size != null) ? Math.min(size, maxSize) : defaultSize;

        return ResponseEntity.ok(
                blogInter.getAllBlogs_2(pageNumber, pageSize)
        );
    }

    @GetMapping("/search")
    public ResponseEntity<Page<All_Blogs_Reponces_Form>> searchBlogs(
            @RequestParam String title,
            @RequestParam(required = false) Integer page,
            @RequestParam(required = false) Integer size) {

        int pageNumber = (page != null) ? page : defaultPage;
        int pageSize = (size != null) ? Math.min(size, maxSize) : defaultSize;

        Page<All_Blogs_Reponces_Form> result = blogInter.searchBlogsByTitle(title, pageNumber, pageSize);
        return ResponseEntity.ok(result);
    }


}
