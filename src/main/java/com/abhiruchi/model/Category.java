package com.abhiruchi.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity

public class Category {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int Cat_Id;
	private String Cat_Name;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "category", fetch = FetchType.LAZY)
    private List<Products> products;
	
	@JsonManagedReference
	public List<Products> getProducts() {
		return products;
	}

	public void setProducts(List<Products> products) {
		this.products = products;
	}

	public int getCat_Id() {
		return Cat_Id;
	}

	public void setCat_Id(int cat_Id) {
		Cat_Id = cat_Id;
	}

	public String getCat_Name() {
		return Cat_Name;
	}

	public void setCat_Name(String cat_Name) {
		Cat_Name = cat_Name;
	}

	
	
	
}
