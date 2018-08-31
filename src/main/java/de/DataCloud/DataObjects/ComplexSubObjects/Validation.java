package de.DataCloud.DataObjects.ComplexSubObjects;

import javax.persistence.Embeddable;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@Embeddable
public class Validation {
	@JsonProperty("required")
	private boolean required;
	
	public Validation(boolean required) {
		this.required = required;
	}
}
