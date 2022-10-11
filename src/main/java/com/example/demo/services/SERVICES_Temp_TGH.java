package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.TGH_Template;
import com.example.demo.repo.Repo_temp_TGH;

@Service
public class SERVICES_Temp_TGH {

	@Autowired 
	private Repo_temp_TGH temp_repo;
	public List<TGH_Template> getByCode(String code){
		return temp_repo.getByCode(code);
	}
	

}
