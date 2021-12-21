package com.example.boardpage.service;

import com.example.boardpage.domain.Board;
import com.example.boardpage.repository.BoardRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class BoardService {

    private final BoardRepository boardRepository;

    public BoardService(BoardRepository boardRepository) {
        this.boardRepository = boardRepository;
    }

    public Page<Board> findBoardList(Pageable pageable) {
        pageable = PageRequest.of(pageable.getPageNumber()<= 0 ? 0: pageable.getPageNumber() -1, pageable.getPageSize());
        return boardRepository.findAll(pageable);
    }

    public Board findBoardById(Long id){
        Board board = boardRepository.findById(id).orElse(new Board());
        return board;
    }

    public Board save(Board board){
        Board savedBoard = boardRepository.save(board);
        return savedBoard;
    }

    public void deleteById(Long id){
        boardRepository.deleteById(id);
    }

}
