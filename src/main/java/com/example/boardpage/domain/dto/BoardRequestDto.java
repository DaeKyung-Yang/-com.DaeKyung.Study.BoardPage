package com.example.boardpage.domain.dto;

import com.example.boardpage.domain.entity.Board;
import com.example.boardpage.domain.entity.User;
import com.example.boardpage.domain.enums.BoardType;
import lombok.*;

@Getter
@NoArgsConstructor
public class BoardRequestDto {

    private String title;
    private String content;
    private BoardType boardType;

    private User user;

    public Board toEntity(){
        Board build = Board.builder()
                .title(title)
                .content(content)
                .boardType(boardType)
                .build();
        return build;
    }
}
