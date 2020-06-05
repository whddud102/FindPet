package com.jy.vo.shelter;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

import com.jy.vo.ShelterDTO;

import lombok.Setter;
import lombok.ToString;

@Setter
@XmlRootElement(name = "body")
@ToString
public class ShelterItemsDTO {
	private List<ShelterItemDTO> items;
	
	@XmlElementWrapper(name = "items")
	@XmlElement(name = "item")
	public List<ShelterItemDTO> getItems() {
		return items;
	}
}
