package com.jy.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.jy.domain.reply.ReplyDto;

@Mapper
public interface ReplyMapper {
	public int insert(ReplyDto reply);
	public ReplyDto read(int rno);
	public int delete(int rno);
	public int update(ReplyDto reply);
	public List<ReplyDto> getList(int bno);
}
