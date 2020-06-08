package com.jy.domain;

import java.util.List;

import com.jy.domain.pet.SearchingPetItemDTO;
import com.jy.domain.pet.SearchingPetItemsDTO;

import lombok.Data;
import lombok.extern.java.Log;

/**
 * 유기동물 리스트 + 페이지 정보를 담을 클래스
 * @author JongYoung
 *
 */
@Log
@Data
public class ResultList {
	private int pageNo;		// 현재 페이지 
	private int numOfRows;	// 페이지 당 데이터 수
	private int totalCount;	// 전체 데이터 수
	private int endPage;	// 마지막 페이지
	private boolean prev;	// 이전 페이지 여부
	private boolean next;	// 다음 페이지 여부
	private List<SearchingPetItemDTO> petList;	// 유기 동물 데이터가 담긴 리스트
	
	public ResultList(SearchingPetItemsDTO itemsDTO) {
		petList = itemsDTO.getItems();
		pageNo = itemsDTO.getPageNo();
		totalCount = itemsDTO.getTotalCount();
		numOfRows = itemsDTO.getNumOfRows();
		endPage = (int)Math.ceil((totalCount * 1.0) / numOfRows);
		prev = (pageNo > 1 ? true : false);
		next = (pageNo < endPage ? true : false);
	}
}
