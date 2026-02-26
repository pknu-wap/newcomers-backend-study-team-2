package com.example.demo.controller;

import com.example.demo.dto.PostRequest;
import com.example.demo.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/posts")
public class PostController {

    private final PostService service;

    @PostMapping
    public ResponseEntity<Long> createPost(@RequestBody PostRequest request) {
        final Long id = service.createPost(request.getTitle(), request.getContent(), request.getAuthor());
        return ResponseEntity.ok(id);
    }
}
