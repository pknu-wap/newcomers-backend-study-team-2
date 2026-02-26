package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Getter
@Table(name = "post")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private String content;

    private String author;

    private LocalDateTime createAt;

    public Post(String title, String content, String author) {
        final LocalDateTime current = LocalDateTime.now();

        this.title = title;
        this.content = content;
        this.author = author;
        this.createAt = current;
    }

    public void update(final String title, final String content, final String author) {
        this.title = title;
        this.content = content;
        this.author = author;
    }
}
