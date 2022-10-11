package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.RSB_SubsData;
import com.example.demo.model.TGH_Generator;
import com.example.demo.repo.RSB_Repo;

@RestController
@RequestMapping("/RSP")
public class RSB_controller {

	@Autowired
	private RSB_Repo rs;
	
	RSB_SubsData h=new RSB_SubsData();
	@GetMapping("/getName")
	public RSB_SubsData retriveNameByTelNum(String caller_number) 
	{
		h.setTelephone_number(caller_number);
		try {
			h.setName(rs.retriveNameByTelNum(caller_number));
		}
		catch (Exception e) {
			h.setName("");
		}
		return  h;
	}
//	public RSB_SubsData retriveNameByTelNum(String caller_number)
//	{ 
//		h.setTelephone_number(caller_number);
//	    try {
//	      	h.setName(rs.retriveNameByTelNum(caller_number));
//		    return h;
//		}
//		catch (Exception e) {
//			return h;
//		}
//	}

}
