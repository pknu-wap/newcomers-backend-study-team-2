package com.example.board.service;

import org.springframework.stereotype.Service;

import com.example.board.entity.Board;
import com.example.board.repository.BoardRepository;
import com.example.board.dto.BoardDTO;
import lombok.RequiredArgsConstructor;
import java.util.List;

    @Service
    @RequiredArgsConstructor
    public class BoardService {
        private final BoardRepository repository;
        public Board write(BoardDTO dto) {
            Board board = new Board();
            board.setTitle(dto.getTitle());
            board.setContent(dto.getContent());

            return repository.save(board);
        }
        public List<Board> findAll(){
            return repository.findAll();
        }
        public Board findOne(Long id){
            return repository.findById(id).orElse(null);
        }
    }
