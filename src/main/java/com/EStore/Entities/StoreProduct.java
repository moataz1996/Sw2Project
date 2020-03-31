package com.EStore.Entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class StoreProduct {
	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer id;
	
	private String productID;
	private String name;
	private String category;
	private float price;
	private String brand;
	private String storeName;
	private String ownerUsername;
	private Integer ViewCount;
	
	public StoreProduct() {
		
		this.productID = "";
		this.name = "";
		this.category = "";
		this.price = 0;
		this.brand = "";
		this.storeName = "";
		this.ownerUsername = "";
		this.ViewCount = 0;
	}
	
	
	public StoreProduct(Integer id, String productID, String name, String category, float price, String brand,
			String storeName, String ownerUsername, Integer viewCount) {
		super();
		this.id = id;
		this.productID = productID;
		this.name = name;
		this.category = category;
		this.price = price;
		this.brand = brand;
		this.storeName = storeName;
		this.ownerUsername = ownerUsername;
		ViewCount = viewCount;
	}


	public Integer getViewCount() {
		return ViewCount;
	}


	public void setViewCount(Integer viewCount) {
		ViewCount = viewCount;
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
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public String getStoreName() {
		return storeName;
	}
	public void setStoreName(String storeName) {
		this.storeName = storeName;
	}
	public String getOwnerUsername() {
		return ownerUsername;
	}
	public void setOwnerUsername(String ownerUsername) {
		this.ownerUsername = ownerUsername;
	}
	
	
	
	
}
