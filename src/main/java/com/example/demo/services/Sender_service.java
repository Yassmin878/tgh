package com.example.demo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.repo.Sender_Repo;

@Service
public class Sender_service {
	@Autowired
	private Sender_Repo senrepo;
	
	public void sender_info(String name,Long gen_id,String telNo)
	{
		senrepo.sender_info(name, gen_id, telNo);
		
	}

}
