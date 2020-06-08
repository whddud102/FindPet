package com.jy.domain.shelter;

import javax.xml.bind.annotation.XmlRootElement;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@XmlRootElement(name = "item")
public class ShelterItemDTO {
	private String careRegNo;
	private String careNm;
}
