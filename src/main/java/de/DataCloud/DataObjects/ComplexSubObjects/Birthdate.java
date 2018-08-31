package de.DataCloud.DataObjects.ComplexSubObjects;

import javax.persistence.Embeddable;

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
	
	public Birthdate(String label, String value, String type) {
		this.label = label;
		this.value = value;
		this.type = type;
	}

}
