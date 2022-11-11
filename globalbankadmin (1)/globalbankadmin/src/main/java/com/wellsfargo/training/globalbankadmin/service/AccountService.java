package com.wellsfargo.training.globalbankadmin.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wellsfargo.training.globalbankadmin.model.Account;
import com.wellsfargo.training.globalbankadmin.model.AccountType;
import com.wellsfargo.training.globalbankadmin.model.Customer;
import com.wellsfargo.training.globalbankadmin.model.Branch;
import com.wellsfargo.training.globalbankadmin.repository.AccountRepository;
import com.wellsfargo.training.globalbankadmin.repository.AccountTypeRepository;
import com.wellsfargo.training.globalbankadmin.repository.BranchRepository;
import com.wellsfargo.training.globalbankadmin.repository.CustomerRepository;



@Service
public class AccountService {

	@Autowired
	private AccountRepository accountRepository;
	
	@Autowired
	private CustomerRepository customerRepository;
	
	@Autowired
	private AccountTypeRepository accountTypeRepository;
	
	@Autowired
	private BranchRepository branchRepository;
	
	
	public boolean add(Account account,int typeId,int customerId,int branchId) {
		// TODO Auto-generated method stub
		
		account.setCustomer(customerRepository.findById(customerId).get());
		account.setAccountType(accountTypeRepository.findById(typeId).get());
		account.setBranch(branchRepository.findById(branchId).get());
		return accountRepository.save(account).equals(account);
	}

	public boolean deleteById(int accountId) {
		// TODO Auto-generated method stub
		try
		{
			accountRepository.deleteById(accountId);
		}
		catch(Exception e)
		{
			return false;
		}
		return true;
	}

	public Account findById(int accountId) {
		// TODO Auto-generated method stub
		Optional<Account> account = accountRepository.findById(accountId);
		if(account.isEmpty())
		{
			return null;
		}
		return account.get();
	}

}
