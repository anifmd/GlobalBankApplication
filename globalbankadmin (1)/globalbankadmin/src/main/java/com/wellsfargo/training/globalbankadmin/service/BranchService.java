package com.wellsfargo.training.globalbankadmin.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wellsfargo.training.globalbankadmin.model.Branch;
import com.wellsfargo.training.globalbankadmin.repository.BranchRepository;
import com.wellsfargo.training.globalbankadmin.repository.CityRepository;

@Service
public class BranchService {
	
	@Autowired
	private BranchRepository branchRepository;
	
	@Autowired
	private CityRepository cityRepository;

	public List<Branch> listAll() {
		// TODO Auto-generated method stub
		List<Branch> branches  = branchRepository.findAll();
		System.out.println(branches);
		return branches;
	}

	public boolean delete(int id) {
		// TODO Auto-generated method stub
		try
		{
			branchRepository.deleteById(id);
		}
		catch(Exception e)
		{
			return false;
		}
		return true;
		
	}

	public boolean save(Branch branch,int cityId) {
		// TODO Auto-generated method stub
		branch.setCity(cityRepository.findById(cityId).get());
		return branchRepository.save(branch).equals(branch);
	}

}
