package com.example.board.service;

import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import com.example.board.entity.BoardEntity;
import com.example.board.repository.BoardRepository;
import com.example.board.dto.BoardDTO;
import lombok.RequiredArgsConstructor;
import java.util.List;

    @Service
    @RequiredArgsConstructor
    public class BoardService {
        private final BoardRepository repository;
        public BoardEntity write(BoardDTO dto) {
            BoardEntity board = new BoardEntity();
            board.setTitle(dto.getTitle());
            board.setContent(dto.getContent());

            return repository.save(board);
        }
        public List<BoardEntity> findAll(){
            return repository.findAll();
        }
        public BoardEntity findOne(Long id){
            return repository.findById(id).orElse(null);
        }

    @Transactional
        public Long update(Long id, BoardDTO requestDTO) {
            BoardEntity board =
        repository.findById(id).orElseThrow(
                () -> new
        IllegalArgumentException("아이디가 없어서 수정 불가능")
        );
            board.update(requestDTO.getTitle(),
        requestDTO.getContent());
            return board.getId();
    }

    @Transactional
        public Long deleteBoard(Long id){
            repository.deleteById(id);
            return id;
    }

    }
