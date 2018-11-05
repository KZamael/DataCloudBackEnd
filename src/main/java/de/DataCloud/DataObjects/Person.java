package de.DataCloud.DataObjects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.*;

import de.DataCloud.DataObjects.ComplexSubObjects.Address;
import de.DataCloud.DataObjects.ComplexSubObjects.Birthdate;
import de.DataCloud.DataObjects.ComplexSubObjects.Name;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
//@Entity
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
	private Name givenName;

	@ApiModelProperty(notes="The given name should have at least 2 characters")
	@Size(min=2, message="The given name should have at least 2 characters")
	@JsonProperty("familyName")
	private Name familyName;
	
	@JsonProperty("birthDate")
	private Birthdate birthDate;
	
	@JsonProperty("address")
	private Address address;

	public Person(Long id, Name givenName, Name familyName, Birthdate birthDate, Address address) {
		this.id = id;
		this.givenName = givenName;
		this.familyName = familyName;
		this.birthDate = birthDate;
		this.address = address;
	}
	
	public Person(Long id, String context, String type, Name givenName, Name familyName, Birthdate birthDate, Address address) {
		this.id = id++;
		this.context = context;
		this.type = type;
		this.givenName = givenName;
		this.familyName = familyName;
		this.birthDate = birthDate;
		this.address = address;
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
	
	public void setGivenName(Name givenName) {
		this.givenName = givenName;
	}
	
	public Name getGivenName() {
		return givenName;
	}
	
	public void setFamilyName(Name familyName) {
		this.familyName = familyName;
	}
	
	public Name getFamilyName() {
		return familyName;
	}
	
	public void setBirthDate(Birthdate birthDate) {
		this.birthDate = birthDate;
	}
	
	public Birthdate getBirthDate() {
		return birthDate;
	}
	
	public String toString() {
		return "" + getID() + " " + getContext() + " " + getType() + " " + getGivenName() + " " + getFamilyName() + " " + getBirthDate();
	}
}