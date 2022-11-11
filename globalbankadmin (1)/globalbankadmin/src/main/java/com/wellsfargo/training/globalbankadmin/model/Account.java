package com.wellsfargo.training.globalbankadmin.model;

import java.io.Serializable;
import java.sql.Date;
import java.util.Optional;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@Entity
@Table(name="accounts")
public class Account{
	
	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="accountId")
    private int id;
	
	@Column(name="openingDate")
	@JsonFormat(pattern="yyyy-MM-dd")
	private Date openingDate;
	
	@Column(name="openingBalance")
	private int openingBalance;
	
	@Column(name="status")
	private boolean status;
	
	
	@ManyToOne
	@JoinColumn(name="typeId")
	private AccountType accountType;
	
	@JsonIgnore
	@OneToOne
    @JoinColumn(name="customerId")
    private Customer customer;
	
	//private Customer customer;
	
	
	@ManyToOne
	@JoinColumn(name="branchId")
	private Branch branch;

	public int getOpeningBalance() {
		return openingBalance;
	}

	public void setOpeningBalance(int openingBalance) {
		this.openingBalance = openingBalance;
	}

	public Date getOpeningDate() {
		return openingDate;
	}

	public void setOpeningDate(Date openingDate) {
		this.openingDate = openingDate;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public AccountType getAccountType() {
		return accountType;
	}

	public void setAccountType(AccountType accountType) {
		this.accountType = accountType;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Branch getBranch() {
		return branch;
	}

	public void setBranch(Branch branch) {
		this.branch = branch;
	}
	
	
}
