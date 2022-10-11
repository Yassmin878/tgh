package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.TGH_TemplateType;
import com.example.demo.repo.TemplateType_Repo;


@Service
public class TemplateType_service {

	@Autowired
	private  TemplateType_Repo temp_reo;
	
	public List<TGH_TemplateType> getall() {
		return temp_reo.findAll();
	}

}
