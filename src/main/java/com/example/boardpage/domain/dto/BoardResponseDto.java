package com.example.boardpage.domain.dto;

import com.example.boardpage.domain.entity.Board;
import com.example.boardpage.domain.entity.User;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class BoardResponseDto {

    private Long id;
    private String title;
    private String content;
    private String boardType;

    private User user;

    private LocalDateTime createdDate;
    private LocalDateTime modifiedDate;

    public BoardResponseDto(Board entity){
        this.id = entity.getId();
        this.title = entity.getTitle();
        this.content = entity.getContent();
        this.boardType = String.valueOf(entity.getBoardType());
        this.user = entity.getUser();
        this.createdDate = entity.getCreatedDate();
        this.modifiedDate = entity.getModifiedDate();
    }
}
