package com.example.boardpage.domain.dto;

import com.example.boardpage.domain.entity.Board;
import com.example.boardpage.domain.entity.User;
import com.example.boardpage.domain.enums.BoardType;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class BoardResponseDto {

    private Long id;
    private String title;
    private String content;
    private String deleteYN;
    private BoardType boardType;

    private User user;

    private LocalDateTime createdDate;
    private LocalDateTime modifiedDate;

    public BoardResponseDto(Board entity){
        this.id = entity.getId();
        this.title = entity.getTitle();
        this.content = entity.getContent();
        this.deleteYN = entity.getDeleteYN();
        this.boardType = entity.getBoardType();
        this.user = entity.getUser();
        this.createdDate = entity.getCreatedDate();
        this.modifiedDate = entity.getModifiedDate();
    }
}
