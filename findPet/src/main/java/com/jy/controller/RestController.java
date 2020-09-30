package com.jy.controller;

import java.util.List; 
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jy.domain.ResultList;
import com.jy.domain.area.AdministrativeAreaItemDTO;
import com.jy.domain.board.BoardDto;
import com.jy.domain.kind.KindItemDTO;
import com.jy.domain.reply.ReplyDto;
import com.jy.domain.shelter.ShelterItemDTO;
import com.jy.service.BoardService;
import com.jy.service.PetService;
import com.jy.service.ReplyService;
import com.jy.utils.SHA256Util;

import lombok.extern.java.Log;

@org.springframework.web.bind.annotation.RestController
@RequestMapping("/api/*")
@Log
public class RestController {
	
	@Autowired
	private PetService petSerivce;
	
	@Autowired
	private BoardService boardService;
	
	@Autowired
	private ReplyService replyService;
	
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
		ResultList result = petSerivce.getPetList(bgnde, endde, upkind, kind, upr_cd, org_cd, shelter, neuter_yn, pageNo);
		log.info("검색 결과 : " + result);
		return result;
	}
	
	@PostMapping(value = "/encrypt", consumes = "application/json", produces = {MediaType.TEXT_PLAIN_VALUE})
	public String getEncrypt(@RequestBody Map<String, String> map) {
		String type = map.get("type");
		String password_raw = map.get("password");
		String password_encrypted;
		int id = Integer.parseInt(map.get("id"));
		
		log.info("getEncrypt() : 비밀번호 (" + password_raw + ") 암호화 요청, 타입 : " + type + " ====" );
		
		// 게시판의 암호화된 비밀번호를 요청한 경우
		if(type.equals("board")) {
			password_encrypted = boardService.get_encryptedPassword(id, password_raw);
		} else {	// 댓글의 암호화된 비밀번호를 요청한 경우
			password_encrypted = replyService.get_encryptedPassword(id, password_raw);
		}

		log.info("암호화 된 비밀번호 : " + password_encrypted);
		return password_encrypted;
	}
	
	
	@PostMapping(value = "/check", consumes = "application/json", produces = {MediaType.TEXT_PLAIN_VALUE})
	public String checkEncryptedPassword(@RequestBody Map<String, String> map) {
		String encrypted_password = map.get("encrypted_password");
		int bno = Integer.parseInt(map.get("id"));
		BoardDto board = boardService.read(bno);
		
		log.info(" ===== 암호화된 비밀번호 비교 요청 =======");
		return Boolean.toString(encrypted_password.equals(board.getPassword()));
	}
	
	
	
}
