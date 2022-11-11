package com.wellsfargo.training.globalbankadmin.controller;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

import java.sql.Date;
import java.time.LocalDate;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.wellsfargo.training.globalbankadmin.GlobalbankadminApplication;
import com.wellsfargo.training.globalbankadmin.model.Account;
import com.wellsfargo.training.globalbankadmin.model.AccountType;
import com.wellsfargo.training.globalbankadmin.model.Branch;
import com.wellsfargo.training.globalbankadmin.model.Customer;
import com.wellsfargo.training.globalbankadmin.service.AccountService;

@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = GlobalbankadminApplication.class)
class AccountControllerTest {
	
	/*@Autowired
	private MockMvc mockMvc;
	@MockBean
	private AccountController accountController;*/
	
	@MockBean
	private AccountService accountService;
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@Test
	void testAddAccount() {
		Account account = getAccount();
		  when(accountService.add(account,1,1,1)).thenReturn(true);
	      assertTrue(accountService.add(account,1,1,1));

	}

	@Test
	void testDeleteAccount() {
		when(accountService.deleteById(1)).thenReturn(true);
	      assertTrue(accountService.deleteById(1));
	}
	
	private Account getAccount() {
	      Account account = new Account();
	      account.setStatus(true);
	      account.setOpeningBalance(5000);
	      LocalDate localDate = LocalDate.of(2014, 9, 11);
	      Date date = Date.valueOf(localDate);
	      account.setOpeningDate(date);
	      return account;
	   }

}
