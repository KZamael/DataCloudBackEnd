package de.DataCloud.DataObjects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Size;

import org.springframework.lang.NonNull;
import com.fasterxml.jackson.annotation.*;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@Entity
@ApiModel(description="All details about a Person. ")
public class Person {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@JsonProperty("id")
	private Long id = null;
	
	@JsonProperty("@context")
	private String context = "http://schema.org";

	@JsonProperty("@type")
	private String type = "Person";

	@ApiModelProperty(notes="The given name should have at least 2 characters")
	@Size(min=2, message="The given name should have at least 2 characters")
	@JsonProperty("givenName")
	private String givenName = null;

	@ApiModelProperty(notes="The given name should have at least 2 characters")
	@Size(min=2, message="The given name should have at least 2 characters")
	@JsonProperty("familyName")
	private String familyName = null;
	@JsonProperty("birthDate")
	private String birthDate = null;

	public Person(Long id, String givenName, String familyName, String birthDate) {
		this.id = id;
		this.givenName = givenName;
		this.familyName = familyName;
		this.birthDate = birthDate;
	}
	
	// 
	public Person(Long id, String context, String type, String givenName, String familyName, String birthDate) {
		this.id = id++;
		this.context = context;
		this.type = type;
		this.givenName = givenName;
		this.familyName = familyName;
		this.birthDate = birthDate;
	}
	
	public Person(){}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public Long getID() {
		return id;
	}
	
	public void setContext(String context) {
		this.context = context;
	}
	
	public String getContext() {
		return context;
	}
	
	public void setType(String type) {
		this.type = type;
	}
	
	public String getType() {
		return type;
	}
	
	public void setGivenName(String givenName) {
		this.givenName = givenName;
	}
	
	public String getGivenName() {
		return givenName;
	}
	
	public void setFamilyName(String familyName) {
		this.familyName = familyName;
	}
	
	public String getFamilyName() {
		return familyName;
	}
	
	public void setBirthDate(String birthDate) {
		this.birthDate = birthDate;
	}
	
	public String getBirthDate() {
		return birthDate;
	}
	
	public String toString() {
		return "" + getID() + " " + getContext() + " " + getType() + " " + getGivenName() + " " + getFamilyName() + " " + getBirthDate();
	}
}