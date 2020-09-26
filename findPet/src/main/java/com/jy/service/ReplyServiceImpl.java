package com.jy.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jy.domain.reply.ReplyDto;
import com.jy.mapper.ReplyMapper;

import lombok.extern.java.Log;

@Log
@Service
public class ReplyServiceImpl implements ReplyService {
	@Autowired
	ReplyMapper replyMapper;
	
	@Override
	public int insert(ReplyDto reply) {
		log.info("==== 댓글 등록 요청 =======");
		log.info(reply.toString());
		return replyMapper.insert(reply);
	}

	@Override
	public ReplyDto read(int rno) {
		log.info("==== 댓글 조회 요청 ====");
		return replyMapper.read(rno);
	}

	@Override
	public int delete(int rno) {
		log.info(" ===== " + rno + "번 댓글 삭제 요청 ======= ");
		return replyMapper.delete(rno);
	}

	@Override
	public int update(ReplyDto reply) {
		log.info("==== " + reply.getRno() + "번 댓글 수정 요청 ======");
		ReplyDto oldReply = replyMapper.read(reply.getRno());
		oldReply.setContents(reply.getContents());
		return replyMapper.update(oldReply);
	}

	@Override
	public List<ReplyDto> getList(int bno) {
		log.info("ReplyService : " + bno + "번 게시글 댓글 목록 조회..." );
		return replyMapper.getList(bno);
	}

}
