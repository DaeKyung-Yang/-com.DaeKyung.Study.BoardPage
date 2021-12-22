package com.example.boardpage.controller;

import com.example.boardpage.domain.Board;
import com.example.boardpage.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@Controller
@RequiredArgsConstructor
@RequestMapping("/board")
public class BoardController {

    private final BoardService boardService;

    @GetMapping({"", "/"})
    public String board(@RequestParam(value = "id", defaultValue = "0") Long id, Model model){
        model.addAttribute("board", boardService.findBoardById(id));
        return "/board/form";
    }

    @GetMapping("/list")
    public String list(@PageableDefault Pageable pageable, Model model){
        model.addAttribute("boardList", boardService.findBoardList(pageable));
        return "/board/list";
    }

    @ResponseBody
    @PostMapping
    public ResponseEntity postBoard(@RequestBody Board board){
        boardService.save(board);
        return new ResponseEntity("{}", HttpStatus.CREATED);
    }

    @ResponseBody
    @PutMapping("/{id}")
    public ResponseEntity putBoard(@PathVariable("id") Long id, @RequestBody Board board){
        Board persistBoard = boardService.findBoardById(id);
        persistBoard.update(board);
        boardService.save(persistBoard);
        return new ResponseEntity("{}", HttpStatus.OK);
    }

    @ResponseBody
    @DeleteMapping("/{id}")
    public ResponseEntity deleteBoard(@PathVariable("id") Long id){
        boardService.deleteById(id);
        return new ResponseEntity("{}", HttpStatus.OK);
    }

}

