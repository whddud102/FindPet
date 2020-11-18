package com.jy.domain.board;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class BoardDto {
	private int bno;	// 게시판 번호
	private String nickname;	// 닉네임
	private String password;	// 비밀번호
	private String title;		// 제목
	private String contents;	// 내용
	private String salt;		// 암호화, 복호화를 위한 salt
	private int hit_cnt;		// 게시판 조회수
	private int reply_cnt;
	private LocalDateTime created_datetime;		// 작성시간
}
