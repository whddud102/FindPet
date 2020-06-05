package com.jy.vo;

import javax.xml.bind.annotation.XmlRootElement;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@XmlRootElement(name = "item")
public class ShelterDTO {
	private String careRegNo;
	private String careNm;
}


