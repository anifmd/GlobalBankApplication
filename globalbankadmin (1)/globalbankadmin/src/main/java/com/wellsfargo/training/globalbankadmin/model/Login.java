package com.wellsfargo.training.globalbankadmin.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;


@Entity
@Table(name="adminuser")
public class Login {

	@Id
	private String username;
    private String password;

    
public Login()
{
		
}

public Login(String username, String password) {
		
		this.username = username;
		this.password = password;
	}
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
}
