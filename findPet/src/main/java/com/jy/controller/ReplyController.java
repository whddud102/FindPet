package com.jy.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.jy.domain.reply.ReplyDto;
import com.jy.service.ReplyService;

import lombok.extern.java.Log;

@Log
@RequestMapping("/replies")
@RestController
public class ReplyController {
	@Autowired
	private ReplyService replyService;
	
	@PostMapping("/{bno}")
	public ResponseEntity<List<ReplyDto>> insert(@RequestBody ReplyDto reply, @PathVariable("bno") int bno) {
		log.info("==== ReplyController : " + bno + "번 게시글 댓글 등록 요청 =======");
		log.info(reply.toString());
		
		replyService.insert(reply);
		return new ResponseEntity<List<ReplyDto>>(getList(bno) ,HttpStatus.CREATED);
	}
	
	private List<ReplyDto> getList(int bno) {
		log.info("ReplyController : " + bno + "번 게시글 댓글 목록 조회......");
		List<ReplyDto> replies = replyService.getList(bno);
		log.info(replies.size() + "개의 댓글 존재...");
		return replies;
	}
	
	@PutMapping("/{bno}")
	public ResponseEntity<List<ReplyDto>> modify(@PathVariable("bno") int bno, @RequestBody ReplyDto newReply) {
		log.info("ReplyController : " + newReply.getRno() + "번 댓글 수정 요청....");
		ReplyDto oldReply = replyService.read(newReply.getRno());
		oldReply.setContents(newReply.getContents());
		log.info("수정된 댓글 내용 : " + oldReply.getContents());
		replyService.update(oldReply);
		
		return new ResponseEntity<List<ReplyDto>>(replyService.getList(bno), HttpStatus.CREATED);
	}
	
	
	@DeleteMapping(value = "/{bno}/{rno}")
	public ResponseEntity<List<ReplyDto>> delete(@PathVariable("bno") int bno, @PathVariable("rno") int rno) {
		log.info("ReplyController : " + rno + "번 댓글 삭제 요청....");
		replyService.delete(rno);
		
		return new ResponseEntity<List<ReplyDto>>(replyService.getList(bno), HttpStatus.OK);
	}
	
	@GetMapping("/{bno}")
	public ResponseEntity<List<ReplyDto>> getReplies(@PathVariable("bno") int bno) {
		log.info("ReplyController : " + bno + "번 게시글의 댓글 목록 조회...");
		
		return new ResponseEntity<List<ReplyDto>>(replyService.getList(bno), HttpStatus.OK);
	}
}
