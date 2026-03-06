package com.example.demo.service;

import com.example.demo.dto.response.PostResponse;
import com.example.demo.entity.Post;
import com.example.demo.exception.BusinessException;
import com.example.demo.exception.ErrorCode;
import com.example.demo.repository.PostRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

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

    public List<PostResponse> getPosts() {
        final List<Post> posts = repository.findAll();
        return posts.stream()
                .map(post -> new PostResponse(
                        post.getId(),
                        post.getTitle(),
                        post.getContent(),
                        post.getAuthor(),
                        post.getCreateAt())
                ).toList();
    }

    public PostResponse getPost(final Long id) {
        final Post post = findPostById(id);
        return new PostResponse(post.getId(), post.getTitle(), post.getContent(), post.getAuthor(), post.getCreateAt());
    }

    @Transactional
    public Long updatePost(final Long id, final String title, final String content, final String author) {
        Post post = findPostById(id);
        post.update(title, content, author);
        return post.getId();
    }

    @Transactional
    public void deletePost(final Long id) {
        repository.deleteById(id);
    }

    private Post findPostById(final Long id) {
        return repository.findById(id).orElseThrow(() -> new BusinessException(ErrorCode.POST_NOT_FOUND));
    }
}
