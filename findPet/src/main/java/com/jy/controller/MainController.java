package com.jy.controller;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.jy.domain.ResultList;
import com.jy.domain.pet.SearchingPetItemDTO;
import com.jy.domain.pet.SearchingPetItemsDTO;
import com.jy.service.PetService;
import com.jy.utils.API_RequestUtil;

import lombok.extern.java.Log;

@Log
@Controller
public class MainController {
	
	@Autowired
	private PetService petService; 
	
	@GetMapping("/home")
	public void goTo_home (Model model) {
		
		// 홈 페이지 요청 시, 항상 오늘 유기된 동물 1페이지 정보를 전달하도록 함
		
		model.addAttribute("result", petService.getTodayPets(1));
		log.info(petService.getTodayPets(1).toString());
	}
	
	@GetMapping("/search")
	public void goTo_search (Model model) {
		
		// 홈 페이지 요청 시, 항상 오늘 유기된 동물 1페이지 정보를 전달하도록 함
	}
	
	@GetMapping("/list")
	public void goTo_list (@ModelAttribute("bgnde") String bgnde, 
			@ModelAttribute("endde") String endde, 
			@ModelAttribute("upkind") String upkind, 
			@ModelAttribute("kind") String kind,
			@ModelAttribute("upr_cd") String upr_cd, 
			@ModelAttribute("org_cd") String org_cd, 
			@ModelAttribute("shelter") String shelter, 
			@ModelAttribute("neuter_yn") String neuter_yn) {
		
		log.info("=========유기동물 검색 페이지 요청 =========");
		log.info("bgnde : " + bgnde);
		log.info("endde : " + endde);
		log.info("upkind : " + upkind);
		log.info("kind : " + kind);
		log.info("upr_cd : " + upr_cd);
		log.info("org_cd : " + org_cd);
		log.info("shelter : " + shelter);
		log.info("neuter_yn : " + neuter_yn);
		log.info("===============================");
	}
	
	@GetMapping("/detail")
	public void goTo_detail(@ModelAttribute("result") SearchingPetItemDTO petDetail) {
		log.info(" ======== 상세 페이지 요청 ========= ");
		log.info(petDetail.toString());
		log.info("===============================");
	}
	
	

}

