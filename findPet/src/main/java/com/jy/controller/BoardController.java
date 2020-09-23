package com.jy.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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
	
	@GetMapping("/register")
	public void registerGET() {
		log.info("===== 게시글 등록 페이지로 이동 =====");
	}
	
	@PostMapping("/register")
	public String registerPOST(BoardDto board, RedirectAttributes rttr) {
		log.info("========== 게시글 등록 요청 =========");
		log.info(board.toString());
		boardService.insert(board);
		
		rttr.addFlashAttribute("isRegistered", true);
		
		return "redirect:/board/list";
	}
	
	@GetMapping("/get")
	public void get(@RequestParam("bno") int bno, Model model) {
		log.info("======== " + bno + "번 게시글 조회 요청 =========");
		model.addAttribute("board", boardService.read(bno));
	}
	
	@GetMapping("/modify")
	public void modifyGET(int bno, String encrypted_password, Model model) {
		log.info("====== " + bno + " 번 게시글 수정 페이지로 이동 (비밀번호 : " + encrypted_password + ") =====");
		BoardDto board = boardService.read(bno);
		model.addAttribute("board", board);
		model.addAttribute("encrypted_password", encrypted_password);
	}
	
	@PostMapping("/modify")
	public String modifyPOST(BoardDto newBoard, RedirectAttributes rttr) {
		log.info(" ====== " + newBoard.getBno() + "번 게시글 수정 ======= ");
		BoardDto oldBoard = boardService.read(newBoard.getBno());
		oldBoard.setTitle(newBoard.getTitle());
		oldBoard.setContents(newBoard.getContents());
		boardService.update(oldBoard);
		
		rttr.addFlashAttribute("isModified", true);
		
		return  "redirect:/board/list";
	}
	
	@PostMapping("/remove")
	public String remove(int bno, RedirectAttributes rttr) {
		log.info("========== " + bno + " 번 게시글 삭제 요청 =========");
		
		rttr.addFlashAttribute("isRemoved", true);
		
		return "redirect:/board/list";
	}
}
