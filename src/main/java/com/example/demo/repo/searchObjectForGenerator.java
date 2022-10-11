package com.example.demo.repo;

import java.util.Date;

import javax.persistence.Column;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

//@NoArgsConstructor
//@AllArgsConstructor
//@Getter
//@Setter

public class searchObjectForGenerator {    
	 private  Long thgeneratorid;
	 private String caller_number;
	 private String caller_name;
	 @JsonFormat(pattern="yyyy-MM-dd")
     private Date  send_date;
	 @JsonFormat(pattern="yyyy-MM-dd")
	 private Date from_send;
	 @JsonFormat(pattern="yyyy-MM-dd")
	 private Date to_send;
	 @JsonFormat(pattern="yyyy-MM-dd")
	 private Date call_date;
	 @JsonFormat(pattern="yyyy-MM-dd")
	 private Date from_call;
	 @JsonFormat(pattern="yyyy-MM-dd")
	 private Date to_call;
	 
	 
	 
	public Long getThgeneratorid() {
		return thgeneratorid;
	}
	public void setThgeneratorid(Long thgeneratorid) {
		this.thgeneratorid = thgeneratorid;
	}
	public String getCaller_number() {
		return caller_number;
	}
	public void setCaller_number(String caller_number) {
		this.caller_number = caller_number;
	}
	public String getCaller_name() {
		return caller_name;
	}
	public void setCaller_name(String caller_name) {
		this.caller_name = caller_name;
	}
	public Date getSend_date() {
		return send_date;
	}
	public void setSend_date(Date send_date) {
		this.send_date = send_date;
	}
	public Date getFrom_send() {
		return from_send;
	}
	public void setFrom_send(Date from_send) {
		this.from_send = from_send;
	}
	public Date getTo_send() {
		return to_send;
	}
	public void setTo_send(Date to_send) {
		this.to_send = to_send;
	}
	public Date getCall_date() {
		return call_date;
	}
	public void setCall_date(Date call_date) {
		this.call_date = call_date;
	}
	public Date getFrom_call() {
		return from_call;
	}
	public void setFrom_call(Date from_call) {
		this.from_call = from_call;
	}
	public Date getTo_call() {
		return to_call;
	}
	public void setTo_call(Date to_call) {
		this.to_call = to_call;
	}
	 

}
