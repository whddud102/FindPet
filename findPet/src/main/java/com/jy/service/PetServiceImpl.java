package com.jy.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jy.domain.ResultList;
import com.jy.utils.API_RequestUtil;

@Service
public class PetServiceImpl implements PetService{
	
	@Autowired
	private API_RequestUtil requester;

	@Override
	public ResultList getTodayPets(int pageNo) {
		
		return new ResultList(requester.request_todayAbandoned(pageNo));
	}
}
