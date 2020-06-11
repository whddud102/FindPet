package com.jy;

import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.URISyntaxException;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import com.jy.domain.area.AdministrativeAreaResponseVO;
import com.jy.domain.kind.KindResponseVO;
import com.jy.domain.pet.SearchingPetResponseVO;
import com.jy.domain.shelter.ShelterResponseVO;
import com.jy.enums.RequestURI;

import lombok.extern.java.Log;

@RunWith(SpringRunner.class)
@SpringBootTest
@Log
public class RestTemplateTests {

	@Autowired
	private RestTemplate restTemplate;
	
	@Test
	public void testURI() {
		log.info("시/도 조회 URI : " + RequestURI.SIDO.getUri());
		log.info("시/군/구 조회 URI : " + RequestURI.SIGUNGU.getUri());
		log.info("보호소 조회 URI : " +  RequestURI.SHLETER.getUri());
		log.info("품종 조회 URI : " +  RequestURI.KIND.getUri());
		log.info("유기 동물 조회 URI : " + RequestURI.SEARCH.getUri());
	}
	
	@Test
	public void test_getSido() throws UnsupportedEncodingException, URISyntaxException {
        URI uri = new URI(RequestURI.SIDO.getUri());
        
        log.info("요청 URI : " + uri.toString());
        AdministrativeAreaResponseVO result = restTemplate.getForObject(uri, AdministrativeAreaResponseVO.class);
        
        printResult(result);
	}
	
	
	@Test
	public void test_getSigungu() throws URISyntaxException {
		URI uri = new URI(RequestURI.SIGUNGU.getUri() + "upr_cd=6110000");
		log.info("요청 URI : " + uri.toString());
		
		AdministrativeAreaResponseVO result = restTemplate.getForObject(uri, AdministrativeAreaResponseVO.class);
		 
		printResult(result);
		
	}
	
	@Test
	public void test_getShelter() throws URISyntaxException {
		URI uri = new URI(RequestURI.SHLETER.getUri() + "upr_cd=6110000&org_cd=3060000");
		log.info("요청 URI : " + uri.toString());
		
		ShelterResponseVO result = restTemplate.getForObject(uri, ShelterResponseVO.class);
		
		printResult(result);
		
	}
	
	@Test
	public void test_getKind() throws URISyntaxException {
		String dogCd = "417000";
		String catCd = "422400";
		String othersCd = "429900";
		
		URI uri = new URI(RequestURI.KIND.getUri() + "up_kind_cd=" + othersCd);
		log.info("요청 URI : " + uri.toString());
		
		KindResponseVO result = restTemplate.getForObject(uri, KindResponseVO.class);
		
		printResult(result);
		
	}
	
	@Test
	public void test_getSearchingResult() throws URISyntaxException {
		URI uri = new URI(RequestURI.SEARCH.getUri());
		log.info("요청 URI : " + uri.toString());
		
		SearchingPetResponseVO result = restTemplate.getForObject(uri, SearchingPetResponseVO.class);
		
		printResult(result);
		
	}
	
	private void printResult(SearchingPetResponseVO responseVO) {
		responseVO.getBody().getItems().forEach(item -> {
			log.info(item.toString());
		});;
	}

	private void printResult(AdministrativeAreaResponseVO responseVO) {
		responseVO.getBody().getItems().forEach(item -> {
			log.info(item.toString());
		});;
	}
	
	private void printResult(ShelterResponseVO responseVO) {
		responseVO.getBody().getItems().forEach(item -> {
			log.info(item.toString());
		});;
	}
	
	private void printResult(KindResponseVO responseVO) {
		responseVO.getBody().getItems().forEach(item -> {
			log.info(item.toString());
		});;
	}
	
}
