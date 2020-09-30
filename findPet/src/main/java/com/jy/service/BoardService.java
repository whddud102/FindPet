package com.jy.service;

import java.util.List;

import com.jy.domain.board.BoardDto;
import com.jy.domain.board.Criteria;

public interface BoardService {
	public void insert(BoardDto board);
	public List<BoardDto> getList(Criteria cri);
	public BoardDto read(int bno);
	public int delete(int bno);
	public int update(BoardDto board);
	public int getTotalCount(Criteria cri);
	public int increase_hitCnt(int bno);
	public String get_encryptedPassword(int bno, String password_raw);
}
