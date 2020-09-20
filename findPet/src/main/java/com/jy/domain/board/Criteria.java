package com.jy.domain.board;

import lombok.Getter;
import lombok.ToString;
import lombok.Setter;

/**
 * 게시판의 검색기준을 담고 있는 클래스
 * @author JongYoung
 *
 */
@Getter
@ToString
public class Criteria {
	private int amount; 	// 한 페이지당 게시글 수
	private int pageNum;	// 요청 페이지 
	private int offset;
	
	public Criteria() {
		this(1, 10);
	}
	
	public Criteria(int pageNum, int amount) {
		this.amount = amount;
		this.pageNum = pageNum;
		this.offset = (pageNum - 1) * 10;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
		this.offset = (pageNum-1) * 10;
	}

	public void setOffset(int offset) {
		this.offset = offset;
	}
	
	
}
