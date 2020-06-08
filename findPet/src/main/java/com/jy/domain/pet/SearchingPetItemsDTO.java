package com.jy.domain.pet;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

import lombok.Setter;
import lombok.ToString;

@Setter
@XmlRootElement(name = "body")
@ToString
public class SearchingPetItemsDTO {
	private List<SearchingPetItemDTO> items;
	private int numOfRows;
	private int pageNo;
	private int totalCount;
	
	@XmlElementWrapper(name = "items")
	@XmlElement(name = "item")
	public List<SearchingPetItemDTO> getItems() {
		return items;
	}

	public int getNumOfRows() {
		return numOfRows;
	}

	public int getPageNo() {
		return pageNo;
	}

	public int getTotalCount() {
		return totalCount;
	}
}
