package com.wellsfargo.training.globalbankadmin.controller;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.wellsfargo.training.globalbankadmin.model.Customer;
import com.wellsfargo.training.globalbankadmin.response.CustomerResponse;
import com.wellsfargo.training.globalbankadmin.service.CustomerService;


@CrossOrigin
@RestController
public class CustomerController {
	
	@Autowired
	private CustomerService customerService;
	
	@GetMapping("/customers")
    public ResponseEntity<List<CustomerResponse>> viewProducts() {
		
        List<Customer> listProducts = customerService.listAll(); //Fetch all objects/records.
        //System.out.println(listProducts.get(0).getAccount());
        
        //Iterator<Customer> it = listProducts.iterator();
        
        List<CustomerResponse> listCustomers  = new ArrayList<CustomerResponse>();
        
        int i=0;
        while (i<listProducts.size()) {
        	 CustomerResponse customer = new CustomerResponse();
        	 customer.setId(listProducts.get(i).getId());
        	 customer.setName(listProducts.get(i).getName());
        	 if(listProducts.get(i).getAccount() == null)
        	 {
        		 System.out.println("null");
        	 
        	 }
        	 else
        	 {
        		 System.out.println("not null");
        		 customer.setOpeningBalance(listProducts.get(i).getAccount().getOpeningBalance());
            	 customer.setOpeningDate(listProducts.get(i).getAccount().getOpeningDate());
            	 customer.setStatus(listProducts.get(i).getAccount().isStatus());
            	 customer.setAccounttype(listProducts.get(i).getAccount().getAccountType().getName());
            	 customer.setBranch(listProducts.get(i).getAccount().getBranch().getName());
        	 }
        	 listCustomers.add(customer);
        	 i++;
        } 
       
        System.out.println(listCustomers);
        return new ResponseEntity<> (listCustomers,HttpStatus.OK);
    }
	
	@RequestMapping("customers/delete/{id}")
    public ResponseEntity<Boolean> deleteCustomer(@PathVariable int id) {
        return new ResponseEntity<> (customerService.delete(id),HttpStatus.OK);      
    }
	
	
	
	
}
