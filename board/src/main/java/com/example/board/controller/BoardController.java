package com.example.board.controller;
// test

import com.example.board.service.BoardService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.board.entity.Board;
import com.example.board.dto.BoardDTO;
import org.springframework.web.bind.annotation.*;
import java.util.List;

    @RestController
    @RequestMapping ("/boards")
    public class BoardController {
        private final BoardService boardService;
        public BoardController (BoardService boardService){
            this.boardService = boardService;
        }

        @PostMapping
        public Board create (@RequestBody BoardDTO dto) {
            return boardService.write(dto);
        }

        @GetMapping
        public List<Board> getAll(){
            return boardService.findAll();
        }
    }

