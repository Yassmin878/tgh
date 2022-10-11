package com.example.demo.controller;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Sender;
import com.example.demo.model.TGH_Generator;
import com.example.demo.model.TGH_Recepient;
import com.example.demo.model.TGH_Telegraph_model;
import com.example.demo.repo.TGH_Telegraph_repo;
import com.example.demo.repo.searchObjectForGenerator;
import com.example.demo.repo.search_object;
import com.example.demo.services.telegraph_services;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/Telegraph")
public class TGH_Telegraph_controller 
{

	@Autowired
	private telegraph_services se;
//controller
	
//	@GetMapping("/getbetweenDates/{date1}/{date2}")
//	public List<TGH_Telegraph_model>getBetweenTwoDates(@PathVariable  String date1, @PathVariable  String date2)throws Exception
//	{
////		date1=date1;
////		date2="29/9/2022";
// 		Date d1=new SimpleDateFormat("dd-MM-yyyy").parse(date1);
//		Date d2=new SimpleDateFormat("dd-MM-yyyy").parse(date2);
//		return  se.getBetweenTwoDates(d1,d2);
//	}

	
//	@GetMapping("/generate")
	
	public void save_telegragh( TGH_Generator gen )
	{
		 se.save_telegragh(gen);
	}
	
//	@ApiOperation(value =" Find All Telegraphs")
//	@GetMapping("/all")
//	public  List<TGH_Telegraph_model>find()
//	{
//		return se.find();
//	}
	
	@ApiOperation(value ="find all by pagination")
	@GetMapping("/allByPagination/{offset}/{pagesize}")
	public Page<TGH_Telegraph_model> fetch (@PathVariable int offset,@PathVariable int pagesize )
	{
		return se.fetch(offset, pagesize);
	}
	@ApiOperation(value ="Search for telegraph by specification and pagination")
	@PostMapping("/Search/{offset}/{pagesize}")
	
	public Page<TGH_Telegraph_model> findBySpecification(@RequestBody search_object sc,@PathVariable int offset,@PathVariable int pagesize)
	  {
		 return se.findBySpecification(sc, offset, pagesize);
	  }
	
//	Get Last Telegraph id  
//	

}
