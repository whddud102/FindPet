package com.jy.vo;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "item")
public class ItemDTO {
	private String orgCd;
	private String orgdownNm;
	
	public String getOrgCd() {
		return orgCd;
	}
	public void setOrgCd(String orgCd) {
		this.orgCd = orgCd;
	}
	public String getOrgdownNm() {
		return orgdownNm;
	}
	public void setOrgdownNm(String orgdownNm) {
		this.orgdownNm = orgdownNm;
	}
	
	@Override
	public String toString() {
		return "orgCd : " + orgCd + ", orgdownNm : " + orgdownNm;
	}
	
}
