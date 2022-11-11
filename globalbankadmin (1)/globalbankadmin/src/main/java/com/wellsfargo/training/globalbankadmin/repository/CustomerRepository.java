package com.wellsfargo.training.globalbankadmin.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.wellsfargo.training.globalbankadmin.model.Customer;


public interface CustomerRepository extends JpaRepository<Customer,Integer>{

	
}
