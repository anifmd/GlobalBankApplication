package com.wellsfargo.training.globalbankadmin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.wellsfargo.training.globalbankadmin.model.Account;
import com.wellsfargo.training.globalbankadmin.request.AccountRequest;
import com.wellsfargo.training.globalbankadmin.service.AccountService;


@CrossOrigin
@RestController
public class AccountController {
	
	@Autowired
	private AccountService accountService;
	
	@PostMapping("/accounts/add")
	public ResponseEntity<Boolean> addAccount(@RequestBody AccountRequest account) {
		
		// also just in case they pass an id in JSON ... set id to 0
		// this is to force a save of new item ... instead of update
		System.out.println(account.getAccountType());
		System.out.println(account.getCustomer());
		System.out.println(account.getBranch());
		System.out.println(account.getOpeningBalance());
		System.out.println(account.getOpeningDate());
		System.out.println(account.isStatus());
		Account newAccount = new Account();
		newAccount.setOpeningBalance(account.getOpeningBalance());
		newAccount.setOpeningDate(account.getOpeningDate());
		newAccount.setStatus(account.isStatus());
		System.out.println(newAccount);
		return new ResponseEntity<> (accountService.add(newAccount,account.getAccountType(),account.getCustomer(),account.getBranch()),HttpStatus.OK);
		
		
	}
	
	@DeleteMapping("/accounts/delete/{id}")
	public ResponseEntity<Boolean> deleteAccount(@PathVariable int id) {
		
		Account account = accountService.findById(id);
		
		// throw exception if null
		
		if (account == null) {
			throw new RuntimeException("Account id not found - " + id);
		}
		
		return new ResponseEntity<>(accountService.deleteById(id),HttpStatus.OK);
		
		
	}
}
