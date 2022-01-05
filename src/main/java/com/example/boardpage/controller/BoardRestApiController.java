package com.example.boardpage.controller;

import com.example.boardpage.domain.dto.BoardRequestDto;
import com.example.boardpage.domain.dto.BoardResponseDto;
import com.example.boardpage.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/boards")
@RequiredArgsConstructor
public class BoardRestApiController {

    private final BoardService boardService;

    @PostMapping
    public long save(final BoardRequestDto boardRequestDto){
        return boardService.save(boardRequestDto);
    }

    @PatchMapping("/{id}")
    public Long save(@PathVariable final Long id, final BoardRequestDto boardRequestDto){
        return boardService.update(id, boardRequestDto);
    }

    @DeleteMapping("/{id}")
    public Long delete(@PathVariable final Long id){
        return boardService.delete(id);
    }

    @GetMapping
    public List<BoardResponseDto> findAll(){
        return boardService.findAll();
    }

    @GetMapping("/{id}")
    public BoardResponseDto findById(@PathVariable final Long id){
        return boardService.findById(id);
    }
}
