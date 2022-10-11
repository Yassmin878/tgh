package com.example.demo.repo;

import java.sql.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


public class search_object 
{
	private Long id;
	private Long gen_id;
	private String caller_name;
	private String address;
	 @JsonFormat(pattern="yyyy-MM-dd")
	private Date  tgh_date; 
	 @JsonFormat(pattern="yyyy-MM-dd")
	private Date from;
	 @JsonFormat(pattern="yyyy-MM-dd")
	private Date to;
	
	public Date getTgh_date() {
		return tgh_date;
	}
	public void setTgh_date(Date tgh_date) {
		this.tgh_date = tgh_date;
	}
	public Date getFrom() {
		return from;
	}
	public void setFrom(Date from) {
		this.from = from;
	}
	public Date getTo() {
		return to;
	}
	public void setTo(Date to) {
		this.to = to;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getGen_id() {
		return gen_id;
	}
	public void setGen_id(Long gen_id) {
		this.gen_id = gen_id;
	}
	public String getCaller_name() {
		return caller_name;
	}
	public void setCaller_name(String caller_name) {
		this.caller_name = caller_name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	}
	
	

//@AllArgsConstructor 
//@NoArgsConstructor
//@Data
//public class search_object {
//	
//  private String key;
//  private Object value;
//  private SearchOperation operation;
//	public search_object(String key, Object value, SearchOperation operation) {
//		super();
//		this.key = key;
//		this.value = value;
//		this.operation = operation;
//	}
//	public search_object() {
//		super();
//		// TODO Auto-generated constructor stub
//	}
//  
//	
//  
//
//}