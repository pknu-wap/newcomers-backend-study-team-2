package com.example.demo.service;

import com.example.demo.entity.Post;
import com.example.demo.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class PostService {

    private final PostRepository repository;

    public Long createPost(final String title, final String content, final String author) {
        final LocalDateTime current = LocalDateTime.now();
        Post post = new Post(title, content, author, current);
        Post saved = repository.save(post);
        return saved.getId();
    }
}
