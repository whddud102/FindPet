package com.jy.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jy.domain.ResultList;
import com.jy.domain.area.AdministrativeAreaItemDTO;
import com.jy.domain.kind.KindItemDTO;
import com.jy.domain.shelter.ShelterItemDTO;
import com.jy.utils.API_RequestUtil;

@Service
public class PetServiceImpl implements PetService{
	
	@Autowired
	private API_RequestUtil requester;

	@Override
	public ResultList getTodayPets(int pageNo) {
		
		return new ResultList(requester.request_todayAbandoned(pageNo));
	}

	@Override
	public List<AdministrativeAreaItemDTO> getSigungu(String upr_cd) {
		return requester.request_AdministrativeArea(upr_cd).getItems();
	}

	@Override
	public List<ShelterItemDTO> getShelter(String upr_cd, String org_cd) {
		return requester.request_Shelter(upr_cd, org_cd).getItems();
	}

	@Override
	public List<KindItemDTO> getKind(String upkind) {
		return requester.request_Kind(upkind).getItems();
	}

	@Override
	public ResultList getPetList(String bgnde, String endde, String upkind, String kind, String upr_cd, String org_cd,
			String shelter, String state, String neuter_yn, Integer pageNo) {
		
		ResultList result = new ResultList( requester.request_search(bgnde, endde, upkind, kind, upr_cd, org_cd, shelter, state, neuter_yn, pageNo, 10));
		return result;
	}
}
