package com.Third_Mini_Project.Repo;

import com.Third_Mini_Project.Entity.Comment;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface Comment_Repo extends JpaRepository<Comment,Long> {

     // 2nd @Query method to get comments by a list of blog IDs
    List<Comment> findByBlog_BlogIdIn(List<Long> blogIds);


    @Query("""
    SELECT c
    FROM Comment c
    JOIN c.blog b
    WHERE b.user.userSno = :userSno
    ORDER BY c.createdAt DESC
""")
    Page<Comment> findCommentsOfUserBlogs(
            @Param("userSno") Long userSno,
            Pageable pageable
    );



}

