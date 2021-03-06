package com.jy.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.jy.domain.pet.SearchingPetItemDTO;

import lombok.extern.java.Log;

@Log
@Controller
public class MainController {
	
	@GetMapping("/home")
	public void goTo_home () {
		// 홈페이지로 이동
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

