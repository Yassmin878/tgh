package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.services.Sender_service;

@RestController
@RequestMapping("/sender")
public class Sender_controller {
	@Autowired
	private Sender_service senserv;
	
//	@GetMapping("/add")
	public void sender_info(String name,Long gen_id,String telNo)
	{
		senserv.sender_info(name, gen_id, telNo);
	}
	

}
