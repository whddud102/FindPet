package com.jy.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.jy.domain.board.BoardDto;

@Mapper
public interface BoardMapper {
	
	public void insert(BoardDto board);
	public List<BoardDto> getList();
	public BoardDto read(int bno);
	public int delete(int bno);
	public int update(BoardDto board);
}
