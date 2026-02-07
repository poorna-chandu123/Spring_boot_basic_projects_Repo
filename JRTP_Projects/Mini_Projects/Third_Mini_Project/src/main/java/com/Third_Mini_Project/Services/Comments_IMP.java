package com.Third_Mini_Project.Services;

import com.Third_Mini_Project.DTO.Comments_Form;
import com.Third_Mini_Project.DTO.Comments_Responce_Form;
import com.Third_Mini_Project.Entity.Comment;
import com.Third_Mini_Project.Entity.User;
import com.Third_Mini_Project.Repo.Comment_Repo;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


@Service
public class Comments_IMP implements Comments_Inter{

    @Autowired
    private Comment_Repo comment_repo;


    @Override
    public boolean Add_Comments(Comments_Form comments_Form) {

        // copy data from DTO to Entity and save
        Comment comment = new Comment();
        BeanUtils.copyProperties(comments_Form, comment);
        comment_repo.save(comment);
        return true;

    }

    // getting comments by login user id
    @Override
    public Page<Comments_Responce_Form> getCommentsOfLoggedInUser(
            int page, int size, HttpSession session) {

        Long userId = (Long) session.getAttribute("userID");

        if (userId == null) {
            throw new RuntimeException("User not logged in");
        }

        Pageable pageable = PageRequest.of(page, size);

        Page<Comment> commentPage =
                comment_repo.findCommentsOfUserBlogs(userId, pageable);

        return commentPage.map(comment -> {
            Comments_Responce_Form dto = new Comments_Responce_Form();
            dto.setEmail(comment.getEmail());
            dto.setComment(comment.getComment());
            dto.setCreatedAt(comment.getCreatedAt());
            return dto;
        });
    }



}
