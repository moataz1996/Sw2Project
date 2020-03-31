package com.EStore.Entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Product {
	
	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer id;
	
	private String productID;
	private String name;
	private String category;
	private float lowestprice;
	private float heighesttprice;

	public Product() {
		  productID="";
		  name="";
		  category="";
		  lowestprice=0;
		  heighesttprice=0;
	}
	public Product(Integer id, String productID, String name, String category, float lowestprice,
			float heighesttprice) {
		super();
		this.id = id;
		this.productID = productID;
		this.name = name;
		this.category = category;
		this.lowestprice = lowestprice;
		this.heighesttprice = heighesttprice;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getProductID() {
		return productID;
	}

	public void setProductID(String productID) {
		this.productID = productID;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public float getLowestprice() {
		return lowestprice;
	}

	public void setLowestprice(float lowestprice) {
		this.lowestprice = lowestprice;
	}

	public float getHeighesttprice() {
		return heighesttprice;
	}

	public void setHeighesttprice(float heighesttprice) {
		this.heighesttprice = heighesttprice;
	}
	

}
