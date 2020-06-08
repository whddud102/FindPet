package com.jy.domain.kind;

import javax.xml.bind.annotation.XmlRootElement;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@XmlRootElement(name = "item")
public class KindItemDTO {
	private String KNm;
	private String kindCd;
}
