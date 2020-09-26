package com.jy;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.jy.domain.board.BoardDto;
import com.jy.domain.board.Criteria;
import com.jy.domain.reply.ReplyDto;
import com.jy.mapper.ReplyMapper;
import com.jy.service.BoardService;
import com.jy.utils.SHA256Util;

import lombok.extern.java.Log;

@Log
@RunWith(SpringRunner.class)
@SpringBootTest
public class DatabaseTests {
	
	@Autowired
	private SqlSessionTemplate sqlSession;
	
	@Autowired
	private BoardService boardSerivce; 
	
	@Autowired
	ReplyMapper replyMapper;
	
	@Test
	public void testSqlSession_exist() {
		log.info("SqlSession : " + sqlSession);
	}
	
	@Test
	public void testService_insert() {
		
		for(int i = 1; i <= 300; i++) {
			BoardDto board = new BoardDto();
			board.setNickname("heavy ass");
			board.setPassword("1234");
			board.setTitle("테스트 제목" + i);
			board.setContents("테스트를 위한 본문내용 " + i);
			
			boardSerivce.insert(board);
			
			log.info("====== 데이터 삽입 완료 =====");
		}
	}
	
	@Test
	public void testService_getList() {
		Criteria cri = new Criteria();
		cri.setPageNum(1);
		
		List<BoardDto> boards = boardSerivce.getList(cri);
		
		log.info("============ 게시글 목록 조회 테스트 (" + cri.getPageNum() + " 페이지 개시글 수 : " + boards.size() + ") ==========");
		for(BoardDto board : boards) {
			log.info(board.toString());
		}
		log.info("==================\n");
	}
	
	@Test
	public void testService_read() {
		log.info("========== 게시글 조회 테스트 ===========");
		BoardDto board = boardSerivce.read(34);
		log.info(board.toString());
		log.info("=================================== ");
	}
	
	@Test
	public void testService_delete() {
		log.info("========== 게시글 삭제 테스트 ===========");
		int result = boardSerivce.delete(32);
		log.info("삭제 결과 : " + result);
		log.info("=================================== ");
	}
	
	@Test
	public void testService_update() {
		log.info("========== 게시글 수정 테스트 ===========");
		BoardDto newBoard = new BoardDto();
		
		newBoard.setBno(34);
		newBoard.setNickname("수정된 닉네임");
		newBoard.setPassword("수정된 비밀번호");
		newBoard.setTitle("수정된 제목");
		newBoard.setContents("수정된 내용");
		
		boardSerivce.update(newBoard);
		BoardDto board = boardSerivce.read(newBoard.getBno());
		
		log.info("수정 결과 : " + board);
		log.info("=================================== ");
	}
	
	@Test
	public void testReply_insert() {
		log.info("=== 댓글 추가 테스트 ======");

		for (int i = 0; i < 20; i++) {
			ReplyDto reply = new ReplyDto();
			reply.setSalt("test" + i);
			reply.setBno(381);
			reply.setContents("댓글 테스트 입니다" + i);
			reply.setNickname("admin");
			reply.setPassword("1234");

			replyMapper.insert(reply);
		}
	}
	
	
	@Test
	public void testReply_read() {
		log.info(" ==== 댓글 조회 테스트 ====");
		ReplyDto reply = replyMapper.read(1);
		log.info(reply.toString());
	}
	
	
	@Test
	public void testReply_delete() {
		log.info(" ==== 댓글 삭제 테스트 ====");
		log.info("result  : " + replyMapper.delete(2));
	}
	
	@Test
	public void testReply_update() {
		log.info(" ==== 댓글 수정 테스트 ====");
		ReplyDto oldReply = replyMapper.read(15);
		oldReply.setContents("수정된 댓글입니다");
		log.info("result  : " + replyMapper.update(oldReply));
	}
	
	@Test
	public void testReply_getList() {
		log.info(" ==== 댓글 목록 조회 테스트 ====");
		List<ReplyDto> list = replyMapper.getList(382);
		
		for(ReplyDto reply : list) {
			log.info(reply.toString());
		}
		
	}
	
	
	
	
}
