package com.EStore.Entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Store {
	
	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer id;
	
	private String name;
	private String location;
	private String type;
	private String ownerUsername;
	private int approved = 0;
	
	public Store() {
		name="";
		location="";
		type="";
		ownerUsername="";
		approved=0;	
	}
	
	public Store(Integer id, String name, String location, String type, String ownerUsername, int approved) {
		super();
		this.id = id;
		this.name = name;
		this.location = location;
		this.type = type;
		this.ownerUsername = ownerUsername;
		this.approved = approved;
	}
	

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

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getOwnerUsername() {
		return ownerUsername;
	}

	public void setOwnerUsername(String ownerUsername) {
		this.ownerUsername = ownerUsername;
	}

	public int getApproved() {
		return approved;
	}

	public void setApproved(int approved) {
		this.approved = approved;
	}
	
}
