package com.wellsfargo.training.globalbankadmin.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wellsfargo.training.globalbankadmin.model.Customer;
import com.wellsfargo.training.globalbankadmin.repository.CustomerRepository;
import com.wellsfargo.training.globalbankadmin.response.CustomerResponse;

@Service
public class CustomerService {
	
	@Autowired
	private CustomerRepository customerRepository;

	public List<Customer> listAll() {
		// TODO Auto-generated method stub
		List<Customer> customers = customerRepository.findAll();
		System.out.println(customers);
		return customers;
	}

	public boolean delete(int id) {
		// TODO Auto-generated method stub
		try {
		customerRepository.deleteById(id);
		}
		catch(Exception e)
		{
			return false;
		}
		return true;
	}

}
