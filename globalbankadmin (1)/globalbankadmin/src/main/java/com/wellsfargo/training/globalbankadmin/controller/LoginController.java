package com.wellsfargo.training.globalbankadmin.controller;

import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.wellsfargo.training.globalbankadmin.model.Login;
import com.wellsfargo.training.globalbankadmin.service.LoginService;

@CrossOrigin
@RestController
public class LoginController {

	@Autowired
    private LoginService userService;

                                   
    /*@RequestMapping("/login")       
    public ModelAndView login() {
    	ModelAndView mav = new ModelAndView("login");
        mav.addObject("user", new Login());
        return mav;
    }*/

    @GetMapping("/login")
    public String login(@RequestParam String username,@RequestParam String password ) {
    	
    	Login oauthUser = userService.login(username,password);
    	System.out.print(oauthUser);
    	if(Objects.nonNull(oauthUser)) 
    	{	
    		return "OK";
    	}
        else 
        {
    		return "NOT OK";
    	}
}
}
