package com.Third_Mini_Project.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "blogs_table", schema = "third_mini_project")
public class Blog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "blog_id")
    private Long blogId;

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "short_description", length = 500)
    private String shortDescription;

    @Column(name = "content", columnDefinition = "TEXT")
    private String content;

    // Many Blogs -> One User
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_sno", nullable = false)
    private User user;

    // One Blog -> Multiple Comments
    @OneToMany(mappedBy = "blog", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Comment> comments;

    // Getters & Setters
}

