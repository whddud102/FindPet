package com.jy.service;

import java.util.List;

import com.jy.domain.ResultList;
import com.jy.domain.area.AdministrativeAreaItemDTO;
import com.jy.domain.kind.KindItemDTO;
import com.jy.domain.shelter.ShelterItemDTO;

public interface PetService {
	public ResultList getTodayPets(int pageNo); 
	
	public List<AdministrativeAreaItemDTO> getSigungu(String upr_cd);
	
	public List<ShelterItemDTO> getShelter(String upr_cd, String org_cd);
	
	public List<KindItemDTO> getKind(String upkind);
	
	public ResultList getPetList(String bgnde, String endde, String upkind, String kind,
			String upr_cd, String org_cd, String shelter, String neuter_yn, Integer pageNo);
}

