package com.jy;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.jy.domain.board.BoardDto;
import com.jy.mapper.BoardMapper;

import lombok.extern.java.Log;

@Log
@RunWith(SpringRunner.class)
@SpringBootTest
public class DatabaseTests {
	
	@Autowired
	private SqlSessionTemplate sqlSession;
	
	@Autowired
	private BoardMapper boardMapper;
	
	@Test
	public void testSqlSession_exist() {
		log.info("SqlSession : " + sqlSession);
	}
	
	@Test
	public void testMapper_insert() {
		
		for(int i = 1; i <= 10; i++) {
			BoardDto board = new BoardDto();
			board.setNickname("heavy ass");
			board.setPassword("1234");
			board.setTitle("테스트 제목" + i);
			board.setContents("테스트를 위한 본문내용 " + i);
			
			boardMapper.insert(board);
			
			log.info("====== 데이터 삽입 완료 =====");
		}
	}
	
	@Test
	public void testMapper_getList() {
		List<BoardDto> boards = boardMapper.getList();
		
		log.info("============ 게시글 목록 조회 테스트 (총 개시글 수 : " + boards.size() + " ==========");
		for(BoardDto board : boards) {
			log.info(board.toString());
		}
		log.info("==================\n");
	}
	
	@Test
	public void testMapper_read() {
		log.info("========== 게시글 조회 테스트 ===========");
		BoardDto board = boardMapper.read(35);
		log.info(board.toString());
		log.info("=================================== ");
	}
	
	@Test
	public void testMapper_delete() {
		log.info("========== 게시글 삭제 테스트 ===========");
		int result = boardMapper.delete(32);
		log.info("삭제 결과 : " + result);
		log.info("=================================== ");
	}
}
