package com.jy.controller;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

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
	
	

}
