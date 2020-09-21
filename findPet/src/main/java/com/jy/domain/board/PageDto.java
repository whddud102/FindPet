package com.jy.domain.board;

import lombok.Getter;
import lombok.ToString;

/**
 * 페이징 처리를 위한 클래스
 * @author JongYoung
 *
 */
@Getter
@ToString
public class PageDto {
	private int startPage;  // 시작 페이지 번호
	private int endPage;	// 실제 페이지의 끝
	private int pageNo;
	
	private int total;
	private Criteria cri;
	
	// current_end_page = 10개 페이지 묶음의 끝
	// endPage = 전체 페이지의 끝
	
	public PageDto(Criteria cri, int total) {
		this.cri = cri;
		this.total = total;
		
		this.endPage = (int)(Math.ceil((total * 1.0) / cri.getAmount()));	//	전체 페이지의 끝
		if(cri.getPageNum() > endPage) 
			cri.setPageNum(endPage);
		
		this.pageNo = cri.getPageNum();
		
		System.out.println("pagindDTO : " + this);
	}
	
}
