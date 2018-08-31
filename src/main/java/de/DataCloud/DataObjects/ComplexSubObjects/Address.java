package de.DataCloud.DataObjects.ComplexSubObjects;

import javax.persistence.Embeddable;
import javax.persistence.Embedded;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@Embeddable
public class Address {
	
	@JsonProperty("label")
	private String label;
	
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
	
	public Address(String label,
			AddressElement addressLocality,
			AddressElement addressRegion,
			AddressElement postalCode,
			AddressElement streetAddress,
			String type)
	{
		this.label = label;
		this.addressLocality = addressLocality;
		this.addressRegion = addressRegion;
		this.postalCode = postalCode;
		this.streetAddress = streetAddress;
		this.type = type;
	}
}
