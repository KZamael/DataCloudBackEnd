package de.DataCloud.DataObjects;

import lombok.Data;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonProperty;

@Data
@Entity
@Table(name = "products")
public class Product {
	@Id 
	@JsonProperty("id") 
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@JsonProperty("@context")
	@Column(nullable = false)
	private String context;

	@JsonProperty("@type")
	@Column(nullable = false)
	private String data_type;
	
	@Column(nullable = false, unique = true)
	private String code;
	
	@JsonProperty("identifier")
	@Column(nullable = false, unique = true)
	private String identifier;
	
	@Column(nullable = false)
	@JsonProperty("category")
	private String category;
	
	@Column(nullable = false)
	@JsonProperty("name")
	private String name;
	
	//description of the item
	@JsonProperty("description")
	private String description;
	
	@JsonProperty("price")
	private double price;
}
