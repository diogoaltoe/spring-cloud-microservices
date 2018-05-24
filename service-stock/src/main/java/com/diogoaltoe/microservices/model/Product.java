package com.diogoaltoe.microservices.model;


import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import java.io.Serializable;

@Entity
@Table(name = "product", schema = "public")
@SequenceGenerator(name = "product_generator", sequenceName = "seq_product", allocationSize = 1, initialValue = 1)
public class Product implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    //@GeneratedValue(strategy = GenerationType.AUTO)
    @GeneratedValue(generator="product_generator")
    private Integer id;

    @NotEmpty(message = "Name required")
	@Size(min = 0, max = 50)
	private String name;
	
    @NotEmpty(message = "Description required")
	@Size(min = 0, max = 255)
	private String description;
	
	@NotNull(message = "Cost required")
	private Double cost;
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	public Double getCost() {
		return cost;
	}

	public void setCost(Double cost) {
		this.cost = cost;
	}
}
