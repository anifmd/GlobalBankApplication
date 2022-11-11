package com.wellsfargo.training.globalbankadmin.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@Entity
@Table(name="customers")
public class Customer{
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="customerId")
    private int id;
	
	@Column(name="customerName")
	private String name;
	
	
	@OneToOne(mappedBy="customer",cascade=CascadeType.REMOVE)
	private Account account;
	
	public Customer() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int customerId) {
		this.id = customerId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}
	
	
	
}
