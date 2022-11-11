package com.wellsfargo.training.globalbankadmin.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.wellsfargo.training.globalbankadmin.model.Account;
import com.wellsfargo.training.globalbankadmin.model.Branch;
import com.wellsfargo.training.globalbankadmin.request.BranchRequest;
import com.wellsfargo.training.globalbankadmin.response.BranchResponse;
import com.wellsfargo.training.globalbankadmin.service.BranchService;

@CrossOrigin
@RestController
public class BranchController {
	
	@Autowired
	private BranchService branchService;
	
	@RequestMapping("/branches")
    public ResponseEntity<List<BranchResponse>> viewBranches() {
        List<Branch> branches = branchService.listAll(); //Fetch all objects/records.
        int i=0;
        List<BranchResponse> listBranches = new ArrayList<BranchResponse>();
        while(i < branches.size())
        {
        	BranchResponse branchResponse = new BranchResponse();
        	branchResponse.setId(branches.get(i).getId());
        	branchResponse.setCity(branches.get(i).getCity().getName());
        	branchResponse.setName(branches.get(i).getName());
        	i++;
        	listBranches.add(branchResponse);
        	
        }

        return new ResponseEntity<>(listBranches,HttpStatus.OK);
    }
	
	@DeleteMapping("branches/delete/{id}")
    public ResponseEntity<Boolean> deleteBranch(@PathVariable int id) {
        return new ResponseEntity<> (branchService.delete(id),HttpStatus.OK);
        //return "redirect:products";      
    }
	
	@PostMapping("/branches/add")
	public ResponseEntity<Boolean> addBranch(@RequestBody BranchRequest branch) {
		
		// also just in case they pass an id in JSON ... set id to 0
		// this is to force a save of new item ... instead of update
		
		//System.out.println(branch.getCity());
		Branch newBranch = new Branch();
		newBranch.setName(branch.getName());
		return new ResponseEntity<> (branchService.save(newBranch,branch.getCity()),HttpStatus.OK);
		
		
	}
}
