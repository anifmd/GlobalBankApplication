package com.wellsfargo.training.globalbankadmin.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wellsfargo.training.globalbankadmin.model.Login;
import com.wellsfargo.training.globalbankadmin.repository.LoginRepository;

@Service
public class LoginService {

	@Autowired
	private LoginRepository repo;
  
    public Login login(String username, String password) 
    {
	  Login user = repo.findByUsernameAndPassword(username, password);
  	  return user;
    }
    
}
