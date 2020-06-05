package com.jy.vo.kind;

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
public class KindItemsDTO {
	private List<KindItemDTO> items;
	
	@XmlElementWrapper(name = "items")
	@XmlElement(name = "item")
	public List<KindItemDTO> getItems() {
		return items;
	}
}
