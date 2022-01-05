package com.example.boardpage.service;

import com.example.boardpage.domain.dto.BoardRequestDto;
import com.example.boardpage.domain.dto.BoardResponseDto;
import com.example.boardpage.domain.entity.Board;
import com.example.boardpage.domain.entity.BoardRepository;
import com.example.boardpage.exception.CustomException;
import com.example.boardpage.exception.ErrorCode;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class BoardService {

    private final BoardRepository boardRepository;

    public BoardService(BoardRepository boardRepository) {
        this.boardRepository = boardRepository;
    }

    @Transactional
    public Long save(BoardRequestDto boardRequestDto){
        Board entity = boardRepository.save(boardRequestDto.toEntity());
        return entity.getId();
    }

    @Transactional
    public Long update(final Long id, final BoardRequestDto boardRequestDto){
        Board entity = boardRepository.findById(id).orElseThrow(() -> new CustomException(ErrorCode.POSTS_NOT_FOUND));
        entity.update(boardRequestDto.getTitle(), boardRequestDto.getContent(), boardRequestDto.getBoardType());
        return id;
    }

    @Transactional
    public Long delete(final Long id){
        Board entity = boardRepository.findById(id).orElseThrow(() -> new CustomException(ErrorCode.POSTS_NOT_FOUND));
        entity.delete();
        return id;
    }

    public List<BoardResponseDto> findAll(){
        Sort sort = Sort.by(Sort.Direction.DESC, "id", "createdDate");
        List<Board> list = boardRepository.findAll(sort);

        List<BoardResponseDto> boardList = new ArrayList<>();
        for(Board entity : list){
            boardList.add(new BoardResponseDto(entity));
        }
        return boardList;
    }

    public BoardResponseDto findById(final Long id){
        Board entity = boardRepository.findById(id).orElseThrow(() -> new CustomException(ErrorCode.POSTS_NOT_FOUND));
        return new BoardResponseDto(entity);
    }
}
