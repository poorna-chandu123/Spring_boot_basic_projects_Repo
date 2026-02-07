package com.Third_Mini_Project.Services;

import com.Third_Mini_Project.DTO.All_Blogs_Reponces_Form;
import com.Third_Mini_Project.Entity.Blog;
import com.Third_Mini_Project.Entity.Comment;
import com.Third_Mini_Project.Repo.Blog_Repo;
import com.Third_Mini_Project.Repo.Comment_Repo;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
@RequiredArgsConstructor
public class Blog_IMP implements Blog_Inter{

    @Autowired
    private Blog_Repo blog_repo;

    @Autowired
    private Comment_Repo comment_repo;


// edi work avuthundi but eila use chesthe performance issue osthundi because prathi blog ki oka oka query comments ki vethukuntundi
    // N+1 problem osthundi danni resolve cheyataniki pegination & Two fetch query logic ni use chesthunnam
   /* @Override
    public List<All_Blogs_Reponces_Form> getAllBlogs() {

        List<Blog> all = blog_repo.findAll();

        return all.stream()
                .map(blogData -> {

                    All_Blogs_Reponces_Form dto = new All_Blogs_Reponces_Form();
                    dto.setTitle(blogData.getTitle());
                    dto.setShortDescription(blogData.getShortDescription());
                    dto.setContent(blogData.getContent());

                    // ✅ Entity → DTO mapping for comments
                    List<All_Blogs_Reponces_Form.CommentDTO> commentDTOs =
                            blogData.getComments().stream()
                                    .map(commentData -> {
                                        All_Blogs_Reponces_Form.CommentDTO cDto =
                                                new All_Blogs_Reponces_Form.CommentDTO();
                                        cDto.setName(commentData.getName());
                                        cDto.setComment(commentData.getComment());
                                        cDto.setCreatedDate(commentData.getCreatedAt());
                                        return cDto;
                                    })
                                    .toList();
                    dto.setComments(commentDTOs);
                    return dto;
                })
                .toList();
    }
*/

// creating one helper method for mapping Blog to All_Blogs_Reponces_Form because of code reusability
// same e help class lo vunde logic ne manam Search method and GettAll records method lo use chesthunnam kanuka

    public List<All_Blogs_Reponces_Form> mapBlogsToDTOs(List<Blog> blogs) {
        if (blogs.isEmpty()) return List.of();

        // Extract blog IDs
        List<Long> blogIds = blogs.stream()
                .map(Blog::getBlogId)
                .toList();

        // Fetch comments
        List<Comment> comments = comment_repo.findByBlog_BlogIdIn(blogIds);

        // Group comments by blogId
        Map<Long, List<Comment>> commentsMap = comments.stream()
                .collect(Collectors.groupingBy(c -> c.getBlog().getBlogId()));

        // Map blogs + comments to DTO
        return blogs.stream().map(blog -> {
            All_Blogs_Reponces_Form dto = new All_Blogs_Reponces_Form();
            dto.setBlogId(Math.toIntExact(blog.getBlogId()));
            dto.setTitle(blog.getTitle());
            dto.setShortDescription(blog.getShortDescription());
            dto.setContent(blog.getContent());

            List<All_Blogs_Reponces_Form.CommentDTO> commentDTOs =
                    commentsMap.getOrDefault(blog.getBlogId(), List.of())
                            .stream()
                            .map(c -> {
                                All_Blogs_Reponces_Form.CommentDTO cd = new All_Blogs_Reponces_Form.CommentDTO();
                                cd.setName(c.getName());
                                cd.setComment(c.getComment());
                                cd.setCreatedDate(c.getCreatedAt());
                                return cd;
                            }).toList();

            dto.setComments(commentDTOs);
            return dto;
        }).toList();
    }

    // retun paginated response kuda comon logic kanuk adaniki oka helper method create chesam
    public Page<All_Blogs_Reponces_Form> mapPageBlogsToDTO(Page<Blog> blogPage) {
        List<All_Blogs_Reponces_Form> dtoList = mapBlogsToDTOs(blogPage.getContent());
        return new PageImpl<>(dtoList, blogPage.getPageable(), blogPage.getTotalElements());
    }



    // find all the records with pagination
    @Override
    @Transactional(readOnly = true)
    public Page<All_Blogs_Reponces_Form> getAllBlogs_2(int page, int size) {
        Pageable pageable = PageRequest.of(page, size, Sort.by("blogId").descending());
        Page<Blog> blogPage = blog_repo.findAll(pageable);

        if (blogPage.isEmpty()) {
            return Page.empty(pageable);
        }

        return mapPageBlogsToDTO(blogPage);
    }

    //  search blogs by title with pagination
    @Override
    @Transactional(readOnly = true)
    public Page<All_Blogs_Reponces_Form> searchBlogsByTitle(String title, int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        Page<Blog> blogPage = blog_repo.findByTitleLikeIgnoreCase(title, pageable);

        if (blogPage.isEmpty()) {
            return Page.empty(pageable);
        }

        return mapPageBlogsToDTO(blogPage);
    }

    // delete method based on userSno and blogId also it should delete all comments associated with that blog as well
    @Override
    @Transactional
    public boolean deleteBlogByUserSnoAndBlogId(HttpSession httpSession, Long blogId) {
        // 1️⃣ Get logged-in user ID from session
        Long userId = (Long) httpSession.getAttribute("userID"); // key should match with the one used during login

        if (userId == null) {
            throw  new RuntimeException ("User not logged in");
        }

        // check if blog exists for that user
        Blog blog = blog_repo.findById(blogId)
                .orElseThrow(() -> new RuntimeException("Blog not found"));
        if (!blog.getUser().getUserSno().equals(userId)) {
            throw new RuntimeException("Blog does not belong to the logged-in user");
        }

        // 2️⃣ Delete blog by userSno and blogId
        blog_repo.deleteByUser_UserSnoAndBlogId(userId, blogId);

        return true;

    }


}
