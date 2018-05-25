package com.diogoaltoe.microservices.model;


import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import java.io.Serializable;

@Entity
@Table(name = "customer", schema = "public")
@SequenceGenerator(name = "customer_generator", sequenceName = "seq_customer", allocationSize = 1, initialValue = 1)
public class Customer implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    //@GeneratedValue(strategy = GenerationType.AUTO)
    @GeneratedValue(generator="customer_generator")
    private Integer id;

    @NotEmpty(message = "First name required")
	@Size(min = 0, max = 255)
    @Column(name = "first_name")
	private String firstName;
	
	@NotNull(message = "Last name required")
	@Size(min = 0, max = 50)
	@Column(name = "last_name")
	private String lastName;
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
}
