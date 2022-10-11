package com.example.demo.services;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.demo.model.Sender;
import com.example.demo.model.TGH_Generator;
import com.example.demo.model.TGH_Recepient;
import com.example.demo.model.TGH_Telegraph_model;
//import com.example.demo.model.TGH_Telegraph_model.TGH_Telegraph_modelBuilder;
import com.example.demo.repo.Search_specification;
import com.example.demo.repo.TGH_Telegraph_repo;
//import com.example.demo.repo.searchObjectForGenerator;
import com.example.demo.repo.search_object;

@Service
public class telegraph_services 
{   @Autowired
	private TGH_Telegraph_repo re;
//service
	public List<TGH_Telegraph_model>getBetweenTwoDates(Date d1, Date d2)
	{
		return re.getBetweenTwoDates(d1,d2);
	}

	
	public void save_telegragh( TGH_Generator gen )
	{ 
		 Date d = new Date();
		 for ( Sender s: gen.getSenders() ) 
		  {
			   for(TGH_Recepient R:gen.getRecepients())
			   {
				   TGH_Telegraph_model tg=new TGH_Telegraph_model();
				   tg.setCaller_name(gen.getCaller_name());
				   tg.setGen_id(gen.getthgeneratorid());
				   tg.setUrgent(gen.getUrgent_flag());
				   tg.setMess(gen.getMessg());
				   tg.setSend_date(gen.getSend_date());
				   tg.setAdmin(gen.getAdmin());
				   tg.setTemp(gen.getTemplate_flag());
				   tg.setInternational(gen.getInternational());
				   tg.setDecoration(gen.getDecoration());
				   tg.setPlan_code(gen.getPlan_code());
				   tg.setUser_code(gen.getUser_code());
				   tg.setNotes(gen.getNotes());
				   tg.setTgh_code("code");
				   tg.setSeq_no(0);
				   tg.setCountry_code(gen.getCountryCode());
				   tg.setGene_by("ahmed");
				   tg.setTgh_date(d);
				   tg.setRedirect(1);
				   tg.setStatus_code("new");
				   tg.setDelv_notice(1);
				   tg.setAddress(R.getAddress());
				   tg.setSendername(s.getSender_name());
				   tg.setRec_name(R.getRec_name());
				   re.save(tg);
			   }
		  }
	}
                        /**      org.springframework.data.domain.Pageable               ???????????????     */
	
	public Page<TGH_Telegraph_model> findBySpecification( search_object sc,int offset, int pagesize)
  {
		Search_specification  spec= new Search_specification(sc);
		org.springframework.data.domain.Pageable p=PageRequest.of(offset, pagesize,Sort.by("id"));
		return  re.findAll(spec,p);
  }
		
	public List<TGH_Telegraph_model>find()
		{
			return  re.findAll();
		}
	
	public Page<TGH_Telegraph_model> fetch (int offset,int pagesize )
		{
			 Page<TGH_Telegraph_model> p=re.findAll(PageRequest.of(offset, pagesize));
			 return p;
		}
		
}
