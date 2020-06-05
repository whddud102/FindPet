package com.jy.vo;

import java.util.Map;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "response")
public class API_ResponseVO {
	
	private Map<String, String> header;
    private ItemsDTO body;
    
    public Map<String, String> getHeader() {
		return header;
	}


	public ItemsDTO getBody() {
		return body;
	}


	public void setBody(ItemsDTO body) {
		this.body = body;
	}

	public void setHeader(Map<String, String> header) {
		this.header = header;
	}
	 
}
