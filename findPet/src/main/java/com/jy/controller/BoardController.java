package com.jy.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jy.domain.board.BoardDto;
import com.jy.domain.board.Criteria;
import com.jy.domain.board.PageDto;
import com.jy.service.BoardService;

import lombok.extern.java.Log;

@Log
@Controller
@RequestMapping("/board/")
public class BoardController {
	
	@Autowired
	private BoardService boardService;
	
	@GetMapping("/list")
	public void list(Model model, Criteria cri) {
		log.info("======== 게시글 조회 요청 ==========");
		
		model.addAttribute("pageDTO", new PageDto(cri, boardService.getTotalCount(cri)));
		List<BoardDto> boards = boardService.getList(cri);
		model.addAttribute("boards", boards);
		log.info(boards.size() + "개의 게시물 조회");
	}
}
