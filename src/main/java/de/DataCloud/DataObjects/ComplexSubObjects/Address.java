package de.DataCloud.DataObjects.ComplexSubObjects;

import java.util.*;

import javax.persistence.Embeddable;
import javax.persistence.Embedded;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@Embeddable
@JsonFormat(shape=JsonFormat.Shape.ARRAY)
public class Address {
	
	@JsonProperty("label")
	private AddressElement label;
	
	// Complex
	@Embedded
	@JsonProperty("addressLocality")
	private AddressElement addressLocality;
	
	@Embedded
	@JsonProperty("addressRegion")
	private AddressElement addressRegion;
	
	@Embedded
	@JsonProperty("postalCode")
	private AddressElement postalCode;
	
	@Embedded
	@JsonProperty("streetAddress")
	private AddressElement streetAddress;
	
	@JsonProperty("type")
	private String type;
	

	public Address(AddressElement label, AddressElement addressLocality,
			AddressElement addressRegion, AddressElement postalCode, AddressElement streetAddress, String type) {
		this.label = label;
		this.addressLocality = addressLocality;
		this.addressRegion = addressRegion;
		this.postalCode = postalCode;
		this.streetAddress = streetAddress;
		this.type = type;
	}
	

	/*public void addElement(int index, AddressElement object) {
		addressProperties.add(index, object);
	}
	
	public List<AddressElement> getAllElements() {
		List<AddressElement> element = new ArrayList<AddressElement>();
		for(int i = 0; i < addressProperties.size(); i++) {
			element.add(addressProperties.get(i));
		}
		return element;
	}*/
}
