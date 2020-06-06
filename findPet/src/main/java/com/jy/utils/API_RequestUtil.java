package com.jy.utils;

import java.net.URI;
import java.net.URISyntaxException;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

import org.apache.http.client.utils.URIBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.jy.enums.RequestURI;
import com.jy.vo.abandonedPet.SearchingPetItemsDTO;
import com.jy.vo.abandonedPet.SearchingPetResponseVO;
import com.jy.vo.administrativeArea.AdministrativeAreaItemsDTO;
import com.jy.vo.administrativeArea.AdministrativeAreaResponseVO;
import com.jy.vo.kind.KindItemsDTO;
import com.jy.vo.kind.KindResponseVO;
import com.jy.vo.shelter.ShelterItemsDTO;
import com.jy.vo.shelter.ShelterResponseVO;

import lombok.extern.java.Log;

/**
 * API 요청을 수행하는 유틸 클래스
 * @author JongYoung
 *
 */
// 스프링의 빈으로 등록하기 위해 @component 어노테이션 사용
// 스프링의 빈으로 등록해서, 의존성을 주입받고, 싱글톤 객채로, 하나의 객체를 계속 이용할 것임
@Log
@Component
public class API_RequestUtil {
	@Autowired
	private RestTemplate restTemplate;
	
	/**
	 * 시/도 조회 메서드
	 * @return 시/도 정보
	 * @throws URISyntaxException 
	 */
	public AdministrativeAreaItemsDTO request_AdministrativeArea() throws URISyntaxException {
		URI uri = new URI(RequestURI.SIDO.getUri());
		log.info("요청 URI : " + uri.toString());
		
		return restTemplate.getForObject(uri, AdministrativeAreaResponseVO.class).getBody();
	}
	
	/**
	 * 시/군/구 조회 메서드
	 * @param upr_Cd 시/도 코드
	 * @return 시/군/구 정보
	 * @throws URISyntaxException 
	 */
	public AdministrativeAreaItemsDTO request_AdministrativeArea(String upr_cd) throws URISyntaxException {
		URI uri = new URI(RequestURI.SIGUNGU.getUri() + "upr_cd=" + upr_cd);
		log.info("요청 URI : " + uri.toString());
		
		return restTemplate.getForObject(uri, AdministrativeAreaResponseVO.class).getBody();
	}
	
	public ShelterItemsDTO request_Shelter(String upr_cd, String org_cd) throws URISyntaxException {
		URI uri = new URI(RequestURI.SHLETER.getUri() + "upr_cd=" + upr_cd + "&org_cd=" + org_cd);
		log.info("요청 URI : " + uri.toString());
		
		return restTemplate.getForObject(uri, ShelterResponseVO.class).getBody();
	}
	
	public KindItemsDTO request_Kind(String up_kind_cd) throws URISyntaxException {
		URI uri = new URI(RequestURI.KIND.getUri() + "up_kind_cd=" + up_kind_cd);
		log.info("요청 URI : " + uri.toString());
		
		return restTemplate.getForObject(uri, KindResponseVO.class).getBody();
	}
	
	/**
	 * 오늘 버려진 유기 동물의 데이터를 반환
	 * @return 오늘 버려진 유기동물의 SearchingPetResopnseVO
	 * @throws URISyntaxException 
	 */
	public SearchingPetItemsDTO request_todayAbandoned() throws URISyntaxException {
		LocalDate todayDate = LocalDate.now();
		String todayStr = todayDate.format(DateTimeFormatter.ofPattern("yyyyMMdd"));
		
		return request_search(todayStr, todayStr, null, null, null, null, null, null, null, null, 100);
		
	}
	
	
	public SearchingPetItemsDTO request_search(
			String bgnde,	// 검색 시작일
			String endde,	// 검색 종료일
			String upkind,	// 축종 코드
			String kind,	// 품종 코드
			String upr_cd,	// 시도 코드
			String org_cd,	// 시군구 코드
			String care_reg_no,	// 보호소 번호
			String state,	// 상태
			String neuter_yn,	// 중성화 여부
			Integer pageNo,	// 페이지 번호
			Integer numOfRows	// 페이지 당 데이터 개수
			) throws URISyntaxException {
		
		StringBuilder uriBuilder = new StringBuilder(RequestURI.SEARCH.getUri());
		
		if(bgnde != null)
			uriBuilder.append("bgnde=" + bgnde);	// BASE_URI의 맨 뒤에 &가 포함되어 있으므로, 첫번째 파라미터는 &를 추가하지 않고 바로 붙여 줌
		
		if(endde != null)
			uriBuilder.append("&endde=" + endde);
		
		if(upkind != null)
			uriBuilder.append("&upkind=" + upkind);
		
		if(kind != null)
			uriBuilder.append("&kind=" + kind);
			
		if(upr_cd != null)
			uriBuilder.append("&upr_cd=" + upr_cd);
			
		if(org_cd != null)
			uriBuilder.append("&org_cd=" + org_cd);
		
		if(care_reg_no != null)
			uriBuilder.append("&care_reg_no=" + care_reg_no);
		
		if(state != null)
			uriBuilder.append("&state=" + state);
			
		if(neuter_yn != null)
			uriBuilder.append("&neuter_yn=" + neuter_yn);
			
		if(pageNo != null)
			uriBuilder.append("&pageNo=" + pageNo);
		
		if(numOfRows != null)
			uriBuilder.append("&numOfRows=" + numOfRows);
		
		URI uri = new URI(uriBuilder.toString());
		
		log.info("요청 URI : " + uri.toString());
		
		return restTemplate.getForObject(uri, SearchingPetResponseVO.class).getBody();
	} 
}
