package com.jy;

import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import com.jy.vo.API_ResponseVO;
import com.jy.vo.ItemDTO;
import com.jy.vo.ItemsDTO;

import lombok.extern.java.Log;

@RunWith(SpringRunner.class)
@SpringBootTest
@Log
public class RestTemplateTests {

	@Autowired
	private RestTemplate restTemplate;
	
	private String SERVICE_KEY = "rwsa2gHO9MpieAaqrNbGiKNPFF7DVwar9YAf6bDkor5A%2F4rEGswSmAnQs8JQmzh8wiAHKsIzVX6fqPRCOh8YbA%3D%3D";
	private String GET_SIDO = "http://openapi.animal.go.kr/openapi/service/rest/abandonmentPublicSrvc/sido?ServiceKey=";

	
	@Test
	public void testURL() {
		log.info("요청 URL 테스트 : " + GET_SIDO + SERVICE_KEY);
	}
	
	@Test
	public void test_getSido() throws UnsupportedEncodingException, URISyntaxException {
		StringBuilder uriBuilder = new StringBuilder("http://openapi.animal.go.kr/openapi/service/rest/abandonmentPublicSrvc/sido"); /*URL*/
        uriBuilder.append("?" + URLEncoder.encode("ServiceKey","UTF-8") + "=" + SERVICE_KEY); /*Service Key*/
        URI uri = new URI(uriBuilder.toString());
        
        
        API_ResponseVO result = restTemplate.getForObject(uri, API_ResponseVO.class);
        
        List<ItemDTO> items = result.getBody().getItems();
        
        for(ItemDTO item : items) {
        	log.info("item : " + item.toString());
        }
	}
}
