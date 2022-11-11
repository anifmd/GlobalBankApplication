package com.wellsfargo.training.globalbankadmin.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;




@Entity
@Table(name="branches")
public class Branch{

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="branchId")
    private int id;
	
	@Column(name="branchName")
	private String name;
	
	@ManyToOne
	@JoinColumn(name="cityId")
	private City city;
	
	@JsonIgnore
	@OneToMany(mappedBy="branch")
	private List<Account> accounts;

	public void setName(String name2) {
		// TODO Auto-generated method stub
		this.name=name2;
	}
	public String getName()
	{
		return this.name;
	}

	public void setCity(City city2) {
		// TODO Auto-generated method stub
		this.city = city2;
	}
	public City getCity()
	{
		return this.city;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
}
