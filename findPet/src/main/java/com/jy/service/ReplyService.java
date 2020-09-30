package com.jy.service;

import java.util.List;

import com.jy.domain.reply.ReplyDto;

public interface ReplyService {
	public int insert(ReplyDto reply);
	public ReplyDto read(int rno);
	public int delete(int rno);
	public int update(ReplyDto reply);
	public List<ReplyDto> getList(int bno);
	public String get_encryptedPassword(int rno, String password_raw);
}
