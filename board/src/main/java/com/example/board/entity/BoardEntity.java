package com.example.board.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.time.LocalDateTime;

    @Entity
    @Getter
    @Setter
    public class BoardEntity {

        @Id
        @GeneratedValue (strategy = GenerationType.IDENTITY)
        private Long id;

        private String title;

        private String content;

                private LocalDateTime createdAt = LocalDateTime.now();
        public void update (String title, String content) {
            this.title = title;
            this.content = content;
        }
    }
