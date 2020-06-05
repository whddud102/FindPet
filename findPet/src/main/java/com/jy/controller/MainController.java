package com.jy.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {
	
	@GetMapping("/hello")
	public String hello() {
		return "hello, 나는 정상 작동 중";
	}
	

}
