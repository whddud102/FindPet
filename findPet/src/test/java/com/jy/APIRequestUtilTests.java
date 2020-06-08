package com.jy;

import java.net.URISyntaxException;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.jy.domain.area.AdministrativeAreaItemsDTO;
import com.jy.domain.kind.KindItemsDTO;
import com.jy.domain.pet.SearchingPetItemsDTO;
import com.jy.domain.shelter.ShelterItemsDTO;
import com.jy.utils.API_RequestUtil;

import lombok.extern.java.Log;

@Log
@RunWith(SpringRunner.class)
@SpringBootTest
public class APIRequestUtilTests {

	@Autowired
	private API_RequestUtil requester;
	
	
	@Test
	public void test_DI() {
		log.info("의존성 주입 테스트 : " + requester);
	}
	
	@Test
	public void request_Sido() throws URISyntaxException {
		printResult(requester.request_AdministrativeArea());
	}
	
	@Test
	public void request_Sigungu() throws URISyntaxException {
		String seoul = "6110000";	// 서울 특별시
		
		printResult(requester.request_AdministrativeArea(seoul));
	}
	
	@Test
	public void request_Shelter() throws URISyntaxException {
		String seoul = "6110000";	// 서울특별시
		
		String joongrang = "3060000";	// 중랑구
		String dobong = "3090000";		// 도봉구
		String mapo = "3130000";	// 마포구
		String songpa = "3230000";	// 송파구
		
		printResult(requester.request_Shelter("6110000", songpa));
	}
	
	
	@Test
	public void request_Kind() throws URISyntaxException {
		String dogCd = "417000";
		String catCd = "422400";
		String othersCd = "429900";
		
		printResult(requester.request_Kind(catCd));
	}
	
	@Test
	public void request_Search() throws URISyntaxException {
		String dogCd = "417000";
		String catCd = "422400";
		String othersCd = "429900";
		
		printResult(requester.request_search("20200605", "20200605", null, null, null, null, null, null, null, 1, 10));
	}
	
	@Test
	public void request_todayAbandoned() throws URISyntaxException {
		// 오늘 버려진 유기동물 데이터 요청
		SearchingPetItemsDTO result = requester.request_todayAbandoned(8);
		
		printResult(result);
		
	}
	
	
	private void printResult(SearchingPetItemsDTO ItemsDTO) {
		SearchingPetItemsDTO response = ItemsDTO;
		
		response.getItems().forEach(item -> {
			log.info(item.toString());
		});;
		
		log.info("페이지 번호 : " + response.getPageNo());
		log.info("페이지 당 데이터 수 : " + response.getNumOfRows());
		log.info("전체 데이터 수 : " + response.getTotalCount());
	}

	private void printResult(AdministrativeAreaItemsDTO ItemsDTO) {
		ItemsDTO.getItems().forEach(item -> {
			log.info(item.toString());
		});;
	}
	
	private void printResult(ShelterItemsDTO ItemsDTO) {
		ItemsDTO.getItems().forEach(item -> {
			log.info(item.toString());
		});;
	}
	
	private void printResult(KindItemsDTO ItemsDTO) {
		ItemsDTO.getItems().forEach(item -> {
			log.info(item.toString());
		});;
	}
}
