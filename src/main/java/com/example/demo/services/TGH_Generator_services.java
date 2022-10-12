package com.example.demo.services;

import java.io.UnsupportedEncodingException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.hibernate.LobHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.server.Session;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.demo.API_Exception.ApiException;
//import com.example.demo.controller.RSB_controller;
import com.example.demo.controller.TGH_Telegraph_controller;
import com.example.demo.model.Sender;
import com.example.demo.model.TGH_Generator;
import com.example.demo.model.TGH_Recepient;
//import com.example.demo.model.TGH_Telegraph_model;
import com.example.demo.repo.Recepient_Repo;
import com.example.demo.repo.Sender_Repo;
import com.example.demo.repo.TGH_Generator_Repo;
import com.example.demo.repo.searchGeneratorTable;
import com.example.demo.repo.searchObjectForGenerator;
//import org.hibernate.impl.SessionImpl;
@Service
public class TGH_Generator_services 
{

	@Autowired
	private TGH_Generator_Repo tgh_repo;
//	@Autowired
//	private RSB_controller rsb_controller;
	@Autowired
	private Sender_Repo send_repo;
	@Autowired
	private TGH_Telegraph_controller telegraph_con;
	@Autowired
	private   Recepient_Repo recep_repo;

//		-------------------------------------------------CREATE GENERATOR----------------------------------------------------------

	public ApiException add_sender(TGH_Generator generator) throws UnsupportedEncodingException
	{ //"Cp1256" ,"windows-1256"
	   
	    generator.setMessg(new String( generator.getMessg().getBytes(), "Cp1256"));
	    System.out.println("FIrst"+generator.getMessg());
//	    char[] ch_arr=generator.getMessg().toCharArray();
////	    List<Character> chars = new ArrayList<>(); 
////	    List<Character> chars_after = new ArrayList<>(); 
//	    char[] ch_arr_after= new  char[ch_arr.length/2];
//        // For each character in the String 
//        // add it to the List 
////        for (char ch :  generator.getMessg().toCharArray()) { 
////  
////            chars.add(ch); 
////        } 
//	    for (int i=0;i<ch_arr.length/2;i++)
//	    {
//	        ch_arr_after[i]=ch_arr[i];
//	        System.out.println("letter"+i+"is \t"+ch_arr[i]);
//	    }
//	  
	    
//	    generator.setMessg(ch_arr_after.toString());
	    System.out.println(generator.getMessg());
//        System.out.println(generator.getMessg());
//		String	name= rsb_controller.retriveNameByTelNum(generator.getCaller_number());
//        generator.setCaller_name(name);
		ApiException api_ex= new ApiException();
		try {
        tgh_repo.save(generator);
        
        Set<Sender>sd=generator.getSenders();
        for(Sender s:sd)
        {
        	s.setGeneration_id(generator.getthgeneratorid());
        }
        
       Set<TGH_Recepient> re=generator.getRecepients();
	   for(TGH_Recepient R:re)
       {
        	R.setGenerator_id(generator.getthgeneratorid());
        	System.out.println("+++++++++++++++++ REC+++++++++++++\t"+ R.getRec_name());
       }
	
		generator.setSenders(sd);
    	send_repo.saveAll(generator.getSenders());
    	generator.setRecepients(re);
    	recep_repo.saveAll(generator.getRecepients());

        telegraph_con.save_telegragh(generator);
         System.out.println("generator object="+generator);
        
		}
		catch (Exception e) {
			api_ex.setReason("Need to run api Gen id ");
			api_ex.setStatus(HttpStatus.BAD_REQUEST);
			api_ex.setTimestamp(LocalDateTime.now());
			api_ex.setStatusCode(HttpStatus.BAD_REQUEST.value());
			
		return api_ex;
		}
		api_ex.setReason("DONE");
		api_ex.setStatus(HttpStatus.OK);
		api_ex.setTimestamp(LocalDateTime.now());
		api_ex.setStatusCode(HttpStatus.OK.value());
		return api_ex;
//		
	}
//	--------------------------------------------------------FIND ALL---------------------------------------------------------------

	public Page<TGH_Generator> fetch (int offset,int pagesize )
	{
		 Page<TGH_Generator> p=tgh_repo.findAll(PageRequest.of(offset, pagesize));
		 return p;
	}
//	--------------------------------------------------------FIND BY ID--------------------------------------------------------------
	
	public Optional<TGH_Generator> fetch_By_id (@PathVariable Long id )

	{
		System.out.println(id);
		return tgh_repo.findById(id);
//				findByGenerator_id(id);
	}
//	--------------------------------------------------------SEARCHING---------------------------------------------------------------

	public  List<TGH_Generator>find(searchObjectForGenerator sc)
	{
		searchGeneratorTable se=new searchGeneratorTable(sc);
	    return tgh_repo.findAll(se);
	}
//	---------------------------------------------------------------------------------------------------------------------
/*	
    public List<TGH_Generator>getBetweenTwoDates(Date d1, Date d2)
	{
		return tgh_repo.getBetweenTwoDates(d1,d2);
	}*/
//	---------------------------------------------------------------------------------------------------------------------

	public  Page<TGH_Generator>  findBySpecification(searchObjectForGenerator sc,int offset,int pagesize)
	{
		searchGeneratorTable se=new searchGeneratorTable(sc);
		org.springframework.data.domain.Pageable p=PageRequest.of(offset, pagesize,Sort.by("thgeneratorid"));
//		= PageRequest.of(0, 5, new Sort(Sort.Direction.ASC, "id") );

		return tgh_repo.findAll(se, p);
	}
//	---------------------------------------------------------------------------------------------------------------------

	public Long getId()
	{
		return tgh_repo.getId();
	}
//	---------------------------------------------------------------------------------------------------------------------
	public Long getSenderlastId()
	{
		return send_repo.getSenderLastId();
	}
//	---------------------------------------------------------------------------------------------------------------------

	public Long getReclastId()
	{
		return recep_repo.getRecLastId();
	}
//	---------------------------------------------------------------------------------------------------------------------

	public concat_Rec_Sender  method_concat()
	{   concat_Rec_Sender sen= new concat_Rec_Sender();
		sen.setRecepient_id(recep_repo.getRecLastId());
	    sen.setSender_id(send_repo.getSenderLastId());
		
		return sen;
	}
	
}


/******* Normal search without Pagination******

*************************************** START************************************

*	public  List<TGH_Generator>findBySpecification(searchObjectForGenerator sc)
*{
*		searchGeneratorTable se=new searchGeneratorTable(sc);
*		return tgh_repo.findAll(se);
*	}
*  ************************************* END***********************************
***/

/**         org.springframework.data.domain.Pageable               ???????????????     */





//public void insert(Long id,String CallerName,String caller_number, int temp_flag, String code_type, String temp_code,
//		int delivary_flag, int urgent_flag, String messg) 
//{
//	 tgh_repo.AddTel(id,CallerName,caller_number,temp_flag,code_type,temp_code,delivary_flag,urgent_flag,messg);
//	
//}

//public void insert_name() {
//	tgh_repo.;
//	
//}

