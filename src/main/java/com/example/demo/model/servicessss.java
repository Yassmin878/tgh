//package com.example.demo.model;
//
//import java.sql.Date;
//import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.domain.Page;
//
//import com.example.demo.repo.search_object;
//import com.google.common.base.Objects;
//
//
//public class servicessss {
//	@Autowired
//	searching searching;
//                               //TelegraphList
//	public Map<String, Object> getTelegraph(PagingObject page , TGH_Telegraph_model TelegraphListObj) {
//		{
//			List<search_object> TelegraphList = new ArrayList<>();
//			
//			TelegraphList.add(new search_object("caller_name" , TelegraphListObj.getCaller_name(), SearchOperation.EQUAL));
//			TelegraphList.add(new search_object("address" , TelegraphListObj.getAddress() , SearchOperation.EQUAL));
//			TelegraphList.add(new search_object("gen_id" , TelegraphListObj.getGen_id() , SearchOperation.EQUAL));
//			TelegraphList.add(new search_object("id" , TelegraphListObj.getId() , SearchOperation.EQUAL));
//			
//		
//
//			if (Objects.nonNull(dispute.getDISPUTE_DATE_TO()))
//			{
//				List<Date> list_Dispute_date = new ArrayList<>();
//				list_Dispute_date.add(dispute.getDISPUTE_DATE());
//				list_Dispute_date.add(dispute.getDISPUTE_DATE_TO());
//				list.add( new search_object("DISPUTE_DATE" ,list_Dispute_date, SearchOperation.BETWEEN) );
//			}
//			else
//				list.add( new search_object("DISPUTE_DATE" , dispute.getDISPUTE_DATE()  , SearchOperation.EQUAL) );
//			Page<TGH_Telegraph_model> pageTuts =  searching.findAllWithFilter(page,  TelegraphList);
//			Map<String, Object> response = new HashMap()<>();
//			response.put("creditList", pageTuts.getContent());
//			response.put("currentPage", pageTuts.getNumber());
//			response.put("totalItems", pageTuts.getTotalElements());
//			response.put("totalPages", pageTuts.getTotalPages());
//			return response;
//
//	}
//
//}
