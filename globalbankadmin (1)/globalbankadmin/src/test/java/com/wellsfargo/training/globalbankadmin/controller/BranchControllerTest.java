package com.wellsfargo.training.globalbankadmin.controller;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.wellsfargo.training.globalbankadmin.GlobalbankadminApplication;
import com.wellsfargo.training.globalbankadmin.model.Account;
import com.wellsfargo.training.globalbankadmin.model.Branch;
import com.wellsfargo.training.globalbankadmin.model.City;
import com.wellsfargo.training.globalbankadmin.model.Customer;
import com.wellsfargo.training.globalbankadmin.service.BranchService;
import com.wellsfargo.training.globalbankadmin.service.CustomerService;

@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = GlobalbankadminApplication.class)
class BranchControllerTest {

	@MockBean
	private BranchService branchService;

	@Test
	void testViewBranches() {
		Branch branch = getBranch();
	      List<Branch> branches = new ArrayList<>();
	      branches.add(branch);
	      when(branchService.listAll()).thenReturn(branches);
	      List<Branch> result = branchService.listAll();
	      assertEquals(result.size(), 1);
	}

	@Test
	void testDeleteBranch() {
		when(branchService.delete(1)).thenReturn(true);
	      assertTrue(branchService.delete(1));
	}

	@Test
	void testAddBranch() {
		Branch branch = getBranch();
		  when(branchService.save(branch,1)).thenReturn(true);
	      assertTrue(branchService.save(branch,1));
	}
	
	private Branch getBranch()
	{
		Branch branch = new Branch();
		branch.setId(3);
		branch.setName("Marathahalli");
		City city = new City();
		city.setId(1);
		city.setName("Bangalore");
		branch.setCity(city);
		return branch;
	}

}
