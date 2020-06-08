package com.jy.domain.kind;

import java.util.Map;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * 행정 구역 데이터를 담을 클래스
 * @author JongYoung
 *
 */
@XmlRootElement(name = "response")
public class KindResponseVO {
	
	private Map<String, String> header;
    private KindItemsDTO body;	// 행정 구역 리스트를 담을 필드
    
    public Map<String, String> getHeader() {
		return header;
	}


	public KindItemsDTO getBody() {
		return body;
	}


	public void setBody(KindItemsDTO body) {
		this.body = body;
	}

	public void setHeader(Map<String, String> header) {
		this.header = header;
	}
	 
}
