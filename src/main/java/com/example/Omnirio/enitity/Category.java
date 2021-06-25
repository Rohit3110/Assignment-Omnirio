package com.example.Omnirio.enitity;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="Category")
public class Category {
	
	private static final long serialVersionUID = 1L;
	
	public Category(String name) {
		super();
		this.name = name;
		
	}
	
	public Category() {
		super();
		
		
	}
	
	@Id 
	@GeneratedValue(strategy = GenerationType.AUTO )
	private Long id;

	@Column
	String name;
	
	
	@ManyToMany
	@JoinTable(
	  name = "category_attribute", 
	  joinColumns = @JoinColumn(name = "cat_id"), 
	  inverseJoinColumns = @JoinColumn(name = "attr_id"))
	  Set<Attribute> categoryAttribute;
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<Attribute> getCategoryAttribute() {
		return categoryAttribute;
	}

	public void setCategoryAttribute(Set<Attribute> categoryAttribute) {
		this.categoryAttribute = categoryAttribute;
	}

}
