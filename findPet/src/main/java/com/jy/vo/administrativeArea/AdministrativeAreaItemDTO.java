package com.jy.vo.administrativeArea;

import javax.xml.bind.annotation.XmlRootElement;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@XmlRootElement(name = "item")
public class AdministrativeAreaItemDTO {
	private String orgCd;
	private String orgdownNm;
	private String uprCd;
}
