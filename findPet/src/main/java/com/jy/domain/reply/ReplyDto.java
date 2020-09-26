package com.jy.domain.reply;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class ReplyDto {
	private int rno;	
	private int bno;
	private String salt;
	private String nickname;
	private String password;
	private String contents;
	private LocalDateTime created_datetime;
}
