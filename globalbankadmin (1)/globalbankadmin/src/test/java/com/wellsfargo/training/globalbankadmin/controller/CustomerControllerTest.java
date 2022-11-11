package com.wellsfargo.training.globalbankadmin.controller;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.wellsfargo.training.globalbankadmin.GlobalbankadminApplication;
import com.wellsfargo.training.globalbankadmin.model.*;
import com.wellsfargo.training.globalbankadmin.response.CustomerResponse;
import com.wellsfargo.training.globalbankadmin.service.AccountService;
import com.wellsfargo.training.globalbankadmin.service.CustomerService;


@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = GlobalbankadminApplication.class)
class CustomerControllerTest {

	@MockBean
	private CustomerService customerService;
	
	
	@Test
   public void TestViewCustomers() throws Exception {
		Customer customer = getCustomer();
	      List<Customer> customers = new ArrayList<>();
	      customers.add(customer);
	      when(customerService.listAll()).thenReturn(customers);
	      List<Customer> result = customerService.listAll();
	      assertEquals(result.size(), 1);
   }
	
	@Test
   public void testdeleteCustomer() throws Exception {
		when(customerService.delete(1)).thenReturn(true);
	      assertTrue(customerService.delete(1));
   }
	
	private Customer getCustomer() {
	      Customer customer = new Customer();
	      customer.setId(1);
	      customer.setName("Reddy");
	      Account account = new Account();
	      account.setOpeningBalance(5000);
	      LocalDate localDate = LocalDate.of(2014, 9, 11);
	      Date date = Date.valueOf(localDate);
	      account.setOpeningDate(date);
	      account.setStatus(true);
	      AccountType type = new AccountType();
	      type.setId(1);
	      type.setName("savings");
	      account.setAccountType(type);
	      customer.setAccount(account);
	      return customer;
	   }

}
