package com.example.demo.controller;

import com.example.demo.common.response.ApiResponse;
import com.example.demo.common.response.ApiResponseFactory;
import com.example.demo.dto.request.PostRequest;
import com.example.demo.dto.response.PostResponse;
import com.example.demo.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/boards")
public class PostController {

    private final PostService service;

    @PostMapping
    public ResponseEntity<ApiResponse<Long>> createPost(@RequestBody PostRequest request) {
        final Long id = service.createPost(request.getTitle(), request.getContent(), request.getAuthor());
        return ResponseEntity.ok(ApiResponseFactory.success(id));
    }

    @GetMapping
    private ResponseEntity<ApiResponse<List<PostResponse>>> getPosts() {
        final List<PostResponse> posts = service.getPosts();
        return ResponseEntity.ok(ApiResponseFactory.success(posts));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<PostResponse>> getPost(@PathVariable Long id) {
        final PostResponse post = service.getPost(id);
        return ResponseEntity.ok(ApiResponseFactory.success(post));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<Void>> updatePost(@PathVariable Long id, @RequestBody PostRequest request) {
        service.updatePost(id, request.getTitle(), request.getContent(), request.getAuthor());
        return ResponseEntity.ok(ApiResponseFactory.success(null));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<Void>> deletePost(@PathVariable Long id) {
        service.deletePost(id);
        return ResponseEntity.ok(ApiResponseFactory.success(null));
    }
}
