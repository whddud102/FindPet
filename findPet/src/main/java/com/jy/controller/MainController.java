package com.jy.controller;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.jy.domain.pet.SearchingPetItemsDTO;
import com.jy.utils.API_RequestUtil;

import lombok.extern.java.Log;

@Log
@Controller
public class MainController {
	
	@Autowired
	private API_RequestUtil requester;
	
	@GetMapping("/home")
	public void goTo_home (Model model, Integer pageNum) {
		if(pageNum == null) {
			pageNum = 1;
		}
		
		SearchingPetItemsDTO result = requester.request_todayAbandoned(pageNum);
		log.info("result : " + result);
		
		
		model.addAttribute("result", result);
	}
	
	

}
