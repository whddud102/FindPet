package com.jy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jy.domain.ResultList;
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
		return petSerivce.getTodayPets(pageNo);
	}
	
}
