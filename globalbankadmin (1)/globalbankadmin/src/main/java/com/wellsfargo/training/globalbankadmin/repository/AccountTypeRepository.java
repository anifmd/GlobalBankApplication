package com.wellsfargo.training.globalbankadmin.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.wellsfargo.training.globalbankadmin.model.AccountType;

@Repository
public interface AccountTypeRepository extends JpaRepository<AccountType,Integer>{

}
