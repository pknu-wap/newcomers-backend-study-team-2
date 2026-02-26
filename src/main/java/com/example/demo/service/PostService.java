package com.example.demo.service;

import com.example.demo.entity.Post;
import com.example.demo.repository.PostRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PostService {

    private final PostRepository repository;

    @Transactional
    public Long createPost(final String title, final String content, final String author) {
        Post post = new Post(title, content, author);
        Post saved = repository.save(post);
        return saved.getId();
    }

    @Transactional
    public Long updatePost(final Long id, final String title, final String content, final String author) {
        Post post = repository.findById(id).orElseThrow(() -> new IllegalArgumentException("게시글 없음"));
        post.update(title, content, author);
        return post.getId();
    }
}
