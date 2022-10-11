package com.example.demo.secuirty.controller;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.secuirty.services.UserDetailsServiceImpl;

@RestController
@RequestMapping("/con")
public class user_controller 
{
//	 @Autowired
//	 private UserDetailsServiceImpl scv;
	 
	 @RequestMapping(method = {RequestMethod.POST},value ="/authentication")	
	public String getuser(String name)
	{
		return "Done";
	}
}
