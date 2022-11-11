package com.wellsfargo.training.globalbankadmin.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.wellsfargo.training.globalbankadmin.model.Account;

public interface AccountRepository extends JpaRepository<Account,Integer>{

	
}
