package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.Getter;

import java.time.LocalDateTime;

@Entity
@Getter
@Table(name = "post")
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private final String title;

    private final String content;

    private final String author;

    private final LocalDateTime createAt;

    public Post(String title, String content, String author, LocalDateTime createAt) {
        this.title = title;
        this.content = content;
        this.author = author;
        this.createAt = createAt;
    }
}
