package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.TGH_TemplateType;
//import com.example.demo.repo.TemplateType_Repo;
import com.example.demo.services.TemplateType_service;

@RestController
@RequestMapping("/TemplateType")
public class TemplateType_controller
{
	
	@Autowired
	private  TemplateType_service temp_srvc;
	
//	@Autowired
//	private  TemplateType_Repo temp_repo;

	@GetMapping("/all")
	public List<TGH_TemplateType> get_all()
	{
    	return temp_srvc.getall();

	}
	

}
