package com.jy.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jy.domain.board.BoardDto;
import com.jy.domain.board.Criteria;
import com.jy.mapper.BoardMapper;

import lombok.extern.java.Log;

@Log
@Service
public class BoardSerivceImpl implements BoardService {

	@Autowired
	private BoardMapper boardMapper;
	
	@Override
	public void insert(BoardDto board) {
		log.info("게시글 추가 : " + board);
		boardMapper.insert(board);
	}

	@Override
	public List<BoardDto> getList(Criteria cri) {
		List<BoardDto> boards = boardMapper.getList(cri);
		log.info(cri.getPageNum() + " 페이지 게시글 목록 조회 (게시글 수 : " + boards.size() + ")");
		
		return boards;
	}

	@Override
	public BoardDto read(int bno) {
		BoardDto board = boardMapper.read(bno);
		log.info(bno + "번 게시글 조회 : " + board);
		return board;
	}

	@Override
	public int delete(int bno) {
		int result = boardMapper.delete(bno);
		log.info(bno + "번 게시글 삭제 - " + result + "개 삭제 완료");
		return result;
	}

	@Override
	public int update(BoardDto board) {
		int result = boardMapper.update(board);
		log.info(board.getBno() + "번 게시글 수정 : " + board);
		return result;
	}
}
