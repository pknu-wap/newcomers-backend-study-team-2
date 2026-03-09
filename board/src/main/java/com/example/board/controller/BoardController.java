package com.example.board.controller;
// test2

import com.example.board.service.BoardService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.board.entity.BoardEntity;
import com.example.board.dto.BoardDTO;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.data.projection.EntityProjection.ProjectionType.DTO;

@RestController
@RequestMapping("/boards")
public class BoardController {
    private final BoardService boardService;

    public BoardController(BoardService boardService) {
        this.boardService = boardService;
    }

    @PostMapping
    public BoardEntity create(@RequestBody BoardDTO dto) {
        return boardService.write(dto);
    }

    @GetMapping
    public List<BoardEntity> getAll() {
        return boardService.findAll();
    }

    @GetMapping("/{id}")
    public BoardEntity getOne(@PathVariable Long id) {
        return boardService.findOne(id);
    }

    @PutMapping("/api/board/{id}")
    public Long update(@PathVariable Long id, @RequestBody BoardDTO dto) {
        return boardService.update(id, dto);
    }

    @DeleteMapping("api/board/{id}")
    public Long deleteBoard(@PathVariable Long id) {
        return boardService.deleteBoard(id);
    }

}

