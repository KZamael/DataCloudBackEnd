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
	
	@JsonProperty("minlength")
	private int min;
	
	@JsonProperty("maxlength")
	private int max;
	
	public Validation(boolean required, int min, int max) {
		this.required = required;
		this.min = min;
		this.max = max;
	}
	
	public Validation(boolean required, int min) {
		this(required, min, 2);
	}
	
	public Validation(boolean required) {
		this(required, 2, 2);
	}
	
	
}
