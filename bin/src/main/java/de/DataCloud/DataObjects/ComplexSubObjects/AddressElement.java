package de.DataCloud.DataObjects.ComplexSubObjects;

import javax.persistence.Embeddable;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@Embeddable
public class AddressElement {
	@JsonProperty("label")
	private String label;
	@JsonProperty("value")
	private String value;
	@JsonProperty("type")
	private String dataType;
	
	public AddressElement(String label, String value, String dataType) {
		this.label = label;
		this.value = value;
		this.dataType = dataType;
	}
}
