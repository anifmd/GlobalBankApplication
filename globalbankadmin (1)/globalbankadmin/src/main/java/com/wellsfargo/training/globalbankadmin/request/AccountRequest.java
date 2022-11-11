package com.wellsfargo.training.globalbankadmin.request;

import java.sql.Date;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;


public class AccountRequest {

	private Date openingDate;
	
	
	private int openingBalance;
	
	
	private boolean status;
	
	
	private int accountType;
	
	
    private int customer;
	
	
	private int branch;


	public Date getOpeningDate() {
		return openingDate;
	}


	public void setOpeningDate(Date openingDate) {
		this.openingDate = openingDate;
	}


	public int getOpeningBalance() {
		return openingBalance;
	}


	public void setOpeningBalance(int openingBalance) {
		this.openingBalance = openingBalance;
	}


	public boolean isStatus() {
		return status;
	}


	public void setStatus(boolean status) {
		this.status = status;
	}


	public int getAccountType() {
		return accountType;
	}


	public void setAccountType(int accountType) {
		this.accountType = accountType;
	}


	public int getCustomer() {
		return customer;
	}


	public void setCustomer(int customer) {
		this.customer = customer;
	}


	public int getBranch() {
		return branch;
	}


	public void setBranch(int branch) {
		this.branch = branch;
	}
}
