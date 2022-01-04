package com.example.boardpage.domain.entity;

import com.example.boardpage.domain.enums.BoardType;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@NoArgsConstructor
@Getter
@Entity
@Table
public class Board {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String content;
    private String delete;
    private BoardType boardType;
    private LocalDateTime createdDate = LocalDateTime.now();
    private LocalDateTime modifiedDate;

    @ManyToOne
    private User user;

    @Builder
    public Board(String title, String content, BoardType boardType, String delete) {
        this.title = title;
        this.content = content;
        this.boardType = boardType;
        this.delete = delete;
    }

    public void update(String title, String content, BoardType boardType) {
        this.title = title;
        this.content = content;
        this.boardType = boardType;
        this.modifiedDate = LocalDateTime.now();
    }

    public void delete(){
        this.delete = "Y";
    }
}