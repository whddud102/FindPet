package com.jy.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jy.domain.ResultList;
import com.jy.domain.area.AdministrativeAreaItemDTO;
import com.jy.domain.kind.KindItemDTO;
import com.jy.domain.shelter.ShelterItemDTO;
import com.jy.service.PetService;

import lombok.extern.java.Log;

@org.springframework.web.bind.annotation.RestController
@RequestMapping("/api/*")
@Log
public class RestController {
	
	@Autowired
	private PetService petSerivce;
	
	@GetMapping("/today/{pageNo}")
	public ResultList getTodayPets(@PathVariable("pageNo") int pageNo) {
		ResultList resultList = petSerivce.getTodayPets(pageNo);
		log.info("오늘의 유기 동물 API 요청 : " + resultList);
		
		return resultList;
	}
	
	@GetMapping("/sigungu/{upr_cd}")
	public List<AdministrativeAreaItemDTO> getSigungu(@PathVariable("upr_cd") String upr_cd) {
		log.info("시/군/구 요청 (upr_cd : " + upr_cd + ")");
		
		return petSerivce.getSigungu(upr_cd);
	}
	
	@GetMapping("/shelter/{upr_cd}/{org_cd}")
	public List<ShelterItemDTO> getShelter(@PathVariable("upr_cd") String upr_cd, @PathVariable("org_cd") String org_cd) {
		log.info("보호소 요청 (upr_cd : " + upr_cd + ", orc_cd : " + org_cd + ")");
		
		return petSerivce.getShelter(upr_cd, org_cd);
	}
	
	@GetMapping("/kind/{upkind}")
	public List<KindItemDTO> getShelter(@PathVariable("upkind") String upkind) {
		log.info("품종 요청 (upkind : " + upkind  + ")");
		
		return petSerivce.getKind(upkind);
	}
	
	
	@GetMapping("/search")
	public ResultList getPetList (@ModelAttribute("bgnde") String bgnde, 
			String endde, 
			String upkind, 
			String kind,
			String upr_cd, 
			String org_cd, 
			String shelter, 
			String state, 
			String neuter_yn,
			Integer pageNo
			) {
		log.info("========= 유기동물 검색 api 요청 =========");
		ResultList result = petSerivce.getPetList(bgnde, endde, upkind, kind, upr_cd, org_cd, shelter, state, neuter_yn, pageNo);
		log.info("검색 결과 : " + result);
		return result;
	}
	
	
	
}
