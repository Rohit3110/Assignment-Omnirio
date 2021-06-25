package com.example.Omnirio.enitity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="Attribute")
public class Attribute {
	
	private static final long serialVersionUID = 1L; 
	
	public Attribute(String name) {
		super();
		this.name = name;
		
	}
	
	public Attribute() {
		super();
		
		
	}
	@Id 
	@GeneratedValue(strategy = GenerationType.AUTO )
	private Long id;

	@Column
	String name;
	
	@ManyToMany(mappedBy = "categoryAttribute",fetch = FetchType.LAZY)
	@JsonIgnore
	Set<Category> category= new HashSet<Category>();



	public Long getId() {
		return id;
	}



	public void setId(Long id) {
		this.id = id;
	}



	public Set<Category> getCategory() {
		return category;
	}



	public void setCategory(Set<Category> category) {
		this.category = category;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
