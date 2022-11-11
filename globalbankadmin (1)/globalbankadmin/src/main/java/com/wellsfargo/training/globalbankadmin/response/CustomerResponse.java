package com.wellsfargo.training.globalbankadmin.response;

import java.sql.Date;

public class CustomerResponse {
	
	private int id;
	
	private String name;
	
	private boolean status;
	
	private Date openingDate;
	
	private int openingBalance;
	
	private String accounttype;
	
	private String branch;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

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

	public String getAccounttype() {
		return accounttype;
	}

	public void setAccounttype(String accounttype) {
		this.accounttype = accounttype;
	}

	public String getBranch() {
		return branch;
	}

	public void setBranch(String branch) {
		this.branch = branch;
	}
	
}
