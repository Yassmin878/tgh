package com.example.demo.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.API_Exception.ApiException;
import com.example.demo.model.Sender;
import com.example.demo.model.TGH_Generator;
import com.example.demo.model.TGH_Recepient;
import com.example.demo.model.TGH_Telegraph_model;
import com.example.demo.repo.Recepient_Repo;
import com.example.demo.repo.Sender_Repo;
import com.example.demo.repo.TGH_Generator_Repo;
import com.example.demo.repo.searchObjectForGenerator;
import com.example.demo.services.TGH_Generator_services;
import com.example.demo.services.concat_Rec_Sender;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
/**
 * @author Yassmin
 *
 */
@RestController
@RequestMapping("/Generate")

public class TGH_Generator_controller 
{

	@Autowired
	private TGH_Generator_services tgh_srv;
	
	
	@Autowired
	private TGH_Generator_Repo re;
	
//	------------------------------------- New ------------------------------

	@GetMapping("/Finding")
	public   TGH_Generator findByUserID(Long id) {
		  return re.findByThgeneratorid(id);
	  }
	@GetMapping("/Findingall")
	public  List< TGH_Generator> findall() {
		  return re.findAll();
	  }
//	
	@ApiOperation(value = "inser in (generator,sender,rec,telegraph) table")
	@PostMapping("/sender&recipient")
	public ApiException  add_sender(@RequestBody TGH_Generator generator)
    {
		return  tgh_srv.add_sender(generator);
	}
	
	@ApiOperation(value = "Find All Generators By Paginition")
	@GetMapping("/api3/{offset}/{pagesize}")
	public Page<TGH_Generator> fetch (@PathVariable int offset,@PathVariable int pagesize )
	{
		return tgh_srv.fetch(offset,pagesize);
	}
	
	@ApiOperation(value = "Find All Generators ( By Specific ID )By Paginition")
	@GetMapping("/api4/{id}")
	public Optional<TGH_Generator> fetch_By_id (@PathVariable Long id )
	{
		return tgh_srv.fetch_By_id(id);
	}
 
	@ApiOperation(value = "Search for generator By specification and pagination ") 
	@PostMapping("/Search/{offset}/{pagesize}")
	public  Page<TGH_Generator> findBySpecification( @RequestBody searchObjectForGenerator sc,@PathVariable int offset, @PathVariable int pagesize)
	{
		return tgh_srv.findBySpecification(sc,offset,pagesize);
	}
	
	@ApiOperation(value = "Get the next value of gen_Id ")
	@GetMapping("/GetID")
	public Long getId()
	{
		 return tgh_srv.getId();
	}
	
}



/***  
	
//#######################################  not test until because the security exception #######################################\\
//	@ApiOperation(value = "Get the next value of gen_Id , sender_id, rec_id")
//	@GetMapping("/getIDs")
//	public concat_Rec_Sender  method_concat()
//	{  
//		return tgh_srv.method_concat();
//	}**/
	
	


/***	
////	@GetMapping("/GetSenderLastID")
////	public Long getsenderId()
////	{
////		return tgh_srv.getSenderlastId();
////	}
////	
////	@GetMapping("/GetRecLastID")
////	public Long getrecId()
////	{
////		return tgh_srv.getReclastId();
////	}
//	
////	@GetMapping("/getbetweenDates/{date1}/{date2}")
////	public List<TGH_Generator>getBetweenTwoDates(@PathVariable String date1, @PathVariable String date2) throws ParseException
////	{
////		Date d1=new SimpleDateFormat("dd-MM-yyyy").parse(date1);
////	    Date d2=new SimpleDateFormat("dd-MM-yyyy").parse(date2);
////		return tgh_srv.getBetweenTwoDates(d1, d2);
////	}
////                       /******* Normal search without Pagination******* /
//                                                            	
//	  /************************************** START************************************
////	@PostMapping("/Search")
//	public  List<TGH_Generator>findBySpecification( @RequestBody searchObjectForGenerator sc)
//	{
//		return tgh_srv.findBySpecification(sc);
////	}
//	   /************************************** END************************************
//
//    /*******  search with  Pagination******* /
//     * 
//     * @param sc
//     * @param offset
//     * @param pagesize
//     * @return
//     */
	
	


