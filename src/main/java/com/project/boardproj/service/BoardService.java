package com.project.boardproj.service;

import com.project.boardproj.entity.Board;
import com.project.boardproj.repository.BoardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import java.util.List;

@Service
public class BoardService {
    @Autowired
    private BoardRepository boardRepository;

    public void write(Board board) {
        boardRepository.save(board);
    }

    public List<Board> boardList() {
        return boardRepository.findAll();
    }

    public Board writeView(Integer board_index) {
        return boardRepository.findById(board_index).get();
    }

    public void writeDelete(Integer board_index) {
        boardRepository.deleteById(board_index);
    }

}
