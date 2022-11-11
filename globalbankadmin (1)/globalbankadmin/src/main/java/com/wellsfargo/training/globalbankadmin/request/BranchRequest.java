package com.wellsfargo.training.globalbankadmin.request;



import lombok.Data;
import lombok.Getter;
import lombok.Setter;


public class BranchRequest {
	
	private String name;
	
	private int city;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getCity() {
		return city;
	}

	public void setCity(int city) {
		this.city = city;
	}
	
}
