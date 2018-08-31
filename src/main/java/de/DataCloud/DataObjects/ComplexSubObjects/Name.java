package de.DataCloud.DataObjects.ComplexSubObjects;

import javax.persistence.Embeddable;
import javax.persistence.Embedded;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@Embeddable
public class Name {
	
	@JsonProperty("label")
	private String label;
	@JsonProperty("value")
	private String value;
	@JsonProperty("type")
	private String dataType;
	
	@Embedded
	@JsonProperty("validation")
	private Validation validation;
	
	public Name(String label, String value, String dataType, Validation validation) {
		this.label = label;
		this.value = value;
		this.dataType = dataType;
		this.validation = validation;
	}
}
