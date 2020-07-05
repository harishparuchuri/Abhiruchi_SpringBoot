package com.abhiruchi.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
public class Products {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int Product_Id;
	private String Product_Name;
	private int Product_Price;
	private String AddedOn;
	private String Product_Image;

    @ManyToOne
    @JoinColumn(name = "Cat_Id")
    private Category category;
    
    
	/*
	 * public int getCategory_Id() { return category.getCat_Id(); }
	 */
    
    
  @JsonBackReference
    public Category getCategory() {
		return category;
	}
    
	public void setCategory(Category category) {
		this.category = category;
	}
	
	public int getProduct_Id() {
		return Product_Id;
	}

	

	public void setProduct_Id(int product_Id) {
		Product_Id = product_Id;
	}

	public String getProduct_Name() {
		return Product_Name;
	}

	public void setProduct_Name(String product_Name) {
		Product_Name = product_Name;
	}

	public int getProduct_Price() {
		return Product_Price;
	}

	public void setProduct_Price(int product_Price) {
		Product_Price = product_Price;
	}

	public String getAddedOn() {
		return AddedOn;
	}

	public void setAddedOn(String addedOn) {
		AddedOn = addedOn;
	}

	public String getProduct_Image() {
		return Product_Image;
	}

	public void setProduct_Image(String product_Image) {
		Product_Image = product_Image;
	}


    
    }
