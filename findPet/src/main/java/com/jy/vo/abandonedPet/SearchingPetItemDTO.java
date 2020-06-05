package com.jy.vo.abandonedPet;

import javax.xml.bind.annotation.XmlRootElement;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@XmlRootElement(name = "item")
public class SearchingPetItemDTO {
	private String age;
	private String careAddr;
	private String careNm;
	private String careTel;
	private String chargeNm;
	private String colorCd;
	private String desertionNo;
	private String filename;
	private String happenDt;
	private String happenPlace;
	private String kindCd;
	private String neuterYn;	// 중성화 여부
	private String noticeEdt;
	private String noticeNo;
	private String noticeSdt;
	private String officetel;
	private String orgNm;
	private String popfile;
	private String processState;
	private String sexCd;
	private String specialMark;
	private String weight;
}
