package com.Third_Mini_Project.Repo;

import com.Third_Mini_Project.Entity.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface Blog_Repo extends JpaRepository<Blog, Long> {

    // Case-insensitive search by title
    @Query("SELECT b FROM Blog b WHERE UPPER(b.title) LIKE CONCAT('%', UPPER(:title), '%')")
    Page<Blog> findByTitleLikeIgnoreCase(@Param("title") String title, Pageable pageable);


    /*  User_UserId works because:
     Blog → User (ManyToOne)
    Spring Data JPA understands nested properties  */

    Page<Blog> findByUser_UserSno(Long userSno, Pageable pageable);

    // delete method based on userSno and blogId also it should delete all comments associated with that blog as well
    void deleteByUser_UserSnoAndBlogId(Long userSno, Long blogId);

}
