package com.jy.enums;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

public enum RequestURI {
	
	// API Service Key : rwsa2gHO9MpieAaqrNbGiKNPFF7DVwar9YAf6bDkor5A%2F4rEGswSmAnQs8JQmzh8wiAHKsIzVX6fqPRCOh8YbA%3D%3D
	
	SIDO("sido"), SIGUNGU("sigungu"), SHLETER("shelter"), KIND("kind"), SEARCH("abandonmentPublic");

	String uri;

	private RequestURI(String uri) {
		this.uri = uri;
	}

	public String getUri() {
		StringBuilder uriBuilder = new StringBuilder("http://openapi.animal.go.kr/openapi/service/rest/abandonmentPublicSrvc/" + uri); /*URL*/
        
		try {
			uriBuilder.append(
					"?" + URLEncoder.encode("ServiceKey","UTF-8") + "=" 
			+ "rwsa2gHO9MpieAaqrNbGiKNPFF7DVwar9YAf6bDkor5A%2F4rEGswSmAnQs8JQmzh8wiAHKsIzVX6fqPRCOh8YbA%3D%3D" + "&"); /*Service Key*/
		} catch (UnsupportedEncodingException e) {
			System.out.println("Enum 타입 RequestURI 에서 값을 가져오는 중에 에러가 발생하였습니다");
		} 
		return uriBuilder.toString();
	}
}
