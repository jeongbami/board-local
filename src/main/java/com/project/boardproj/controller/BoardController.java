package com.project.boardproj.controller;

import com.project.boardproj.entity.Board;
import com.project.boardproj.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/board")
public class BoardController {
    @Autowired
    private BoardService boardService;


    @GetMapping("/write")
    public String boardWriteForm() {
        return "boardWrite";
    }

    @PostMapping("/boardwriteprocess")
    public String boardWriteProcess(Board board){
        boardService.write(board);
        return "";
    }

    @GetMapping("/list")
    public String boardList(Model model) {
        model.addAttribute("list", boardService.boardList());
        return "boardList";
    }

    @GetMapping("/writeview")
    public String boardWriteView(Model model, Integer board_index) {
        model.addAttribute("board", boardService.writeView(board_index));
        return "boardWriteView";
    }

    @GetMapping("/writedelete")
    public String boardWriteDelete(Integer board_index) {
        boardService.writeDelete(board_index);

        return "redirect:/board/list";
    }

    @GetMapping("/writemodify/{board_index}")
    public String boardWriteModify(@PathVariable("board_index") Integer board_index,
                                   Model model) {
        model.addAttribute("board", boardService.writeView(board_index));
        return "boardWriteModify";
    }

    @PostMapping ("/writeupdate/{board_index}")
        public String writeUpdate(@PathVariable("board_index") Board board, Integer board_index){
        Board boardUpdateTemp = boardService.writeView(board_index);
        boardUpdateTemp.setBoard_title(board.getBoard_title());
        boardUpdateTemp.setBoard_content(board.getBoard_content());

        boardService.write(boardUpdateTemp);
        return "redirect:/board/list";
    }
}
