package com.jy.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.jy.domain.board.BoardDto;
import com.jy.domain.board.Criteria;

@Mapper
public interface BoardMapper {
	
	public void insert(BoardDto board);
	public List<BoardDto> getList(Criteria cri);
	public BoardDto read(int bno);
	public int delete(int bno);
	public int update(BoardDto board);
	public int getTotalCount(Criteria cri);
	public int increase_hitCnt(int bno);
}
