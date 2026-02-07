package com.Third_Mini_Project.DTO;


import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data

// edi add cheyataniki reason enti ante response lo comments anevi first and next blog detaisl vasthunnay
// so adi correct order lo ravali ante manki ye order kavalo adi eikkada evvali
// normal ga JSON lo order guaranteed ga eilane vastadi ani confirm ledu so andukani @JsonPropertyOrder use chesam
@JsonPropertyOrder({
        "title",
        "shortDescription",
        "content",
        "comments"
})
public class All_Blogs_Reponces_Form {

    private  Integer blogId;
    private String title;
    private String shortDescription;
    private String content;
    private List<CommentDTO> comments;

    // 🔹 Inner DTO
    @Data
    public static class CommentDTO {
        private String name;
        private String comment;
        private LocalDateTime createdDate;

        // one-to-many relationship here so that one DTO is not recommended
    }
}
