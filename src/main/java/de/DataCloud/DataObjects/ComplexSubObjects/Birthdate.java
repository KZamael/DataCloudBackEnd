package de.DataCloud.DataObjects.ComplexSubObjects;

import javax.persistence.Embeddable;
import javax.persistence.Embedded;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@Embeddable
public class Birthdate {
	
	@JsonProperty("label")
	private String label;
	@JsonProperty("value")
	private String value;
	@JsonProperty("type")
	private String type;
	
	@Embedded
	@JsonProperty("validation")
	private Validation validation;
	
	public Birthdate(String label, String value, String type) {
		this.label = label;
		this.value = value;
		this.type = type;
	}
	
	public Birthdate(String label, String value, String type, Validation validation) {
		this.label = label;
		this.value = value;
		this.type = type;
		this.validation = validation;
	}
}
