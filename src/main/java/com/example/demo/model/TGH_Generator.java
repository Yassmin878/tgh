package com.example.demo.model;


//import java.time.LocalDate;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

import org.springframework.lang.NonNull;
import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonFormat;



@Entity
@Table(name="TGH_GENERATOR")
@Validated
@Valid
//
@NamedEntityGraph(name = "Generator.senders",attributeNodes = {
	    @NamedAttributeNode("senders"),
	      @NamedAttributeNode("Recepients")})
public class TGH_Generator {

	 @Id
//	 @GeneratedValue(strategy = GenerationType.SEQUENCE,generator ="id_SEQ" )
//	 @SequenceGenerator(name = "id_SEQ", sequenceName="TGH_GENERATOR_SEQ1",  allocationSize = 1)
//	 because find next id return this id and ++ id
	
	 @Column(name="GEN_ID",updatable=false )
	 private  Long thgeneratorid;

	 @JsonFormat(pattern="yyyy-MM-dd")
	 @Column(name="CALL_DATE" )
	 private Date call_date;

	 @Column(name= "CALLER_TEL_NO",updatable=false )
	 private String caller_number="23934389";
	 
	 @Column(name="CALLER_NAME",updatable=true ,length = 20)
	 private String caller_name;
	 
	 @JsonFormat(pattern="yyyy-MM-dd hh:mm:ss")
	 @Column(name= "SEND_DATE",updatable=true)
     private Date  send_date;
	
	 @Column(name= "TEMPLATE",updatable=true)
	 private int template_flag=0;
	 
	 @Column(name= "TEMP_TYPE_CODE",length =10)
	 private String code_type_temp;
	
	 @Column(name= "TEMP_CODE",length =10)
	 private String temp_Code;
	 
	 @Column(name= "DELIVERY_NOTICE",updatable=true)
	 private int delivery_notice_flag;
	 	 
	 @Column(name= "URGENT",updatable=true)
	 private int urgent_flag;

	 @Lob
	 @Column(name=  "MESSAGE")
	 private String messg;
	
	 @Column(name="USER_CODE")
	 private String user_code;
	 
	 @Column(name="PLAN_CODE")
	 private String plan_code;
	 
	 @Column(name="DECORATION")
	 private int decoration;
	 
	 @Column(name="ADMIN")
	 private int admin;
	 
	 @Column(name="INTERNATIONAL")
	 private int international;
	 
	 @Column(name="NOTES")
	 private String notes;
	 
	 @Column(name="COUNTRY_CODE")
	 private String  countryCode;
		
	 @OneToMany(mappedBy="thg",fetch = FetchType.EAGER)
	 private Set<Sender> senders;
	 
	 @OneToMany(mappedBy="gene",fetch = FetchType.EAGER)
	 private Set<TGH_Recepient> Recepients;
 
	public TGH_Generator() {
		super();
	}

	

	public TGH_Generator(Long thgeneratorid, Date call_date, String caller_number, String caller_name, Date send_date,
            int template_flag, String code_type_temp, String temp_Code, int delivery_notice_flag, int urgent_flag,
            String messg, String user_code, String plan_code, int decoration, int admin, int international,
            String notes, String countryCode, Set<Sender> senders, Set<TGH_Recepient> recepients) {
        super();
        this.thgeneratorid = thgeneratorid;
        this.call_date = call_date;
        this.caller_number = caller_number;
        this.caller_name = caller_name;
        this.send_date = send_date;
        this.template_flag = template_flag;
        this.code_type_temp = code_type_temp;
        this.temp_Code = temp_Code;
        this.delivery_notice_flag = delivery_notice_flag;
        this.urgent_flag = urgent_flag;
        this.messg = messg;
        this.user_code = user_code;
        this.plan_code = plan_code;
        this.decoration = decoration;
        this.admin = admin;
        this.international = international;
        this.notes = notes;
        this.countryCode = countryCode;
        this.senders = senders;
        Recepients = recepients;
    }



    public String getUser_code() {
		return user_code;
	}


	public String getCountryCode() {
		return countryCode;
	}


	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}


	public void setUser_code(String user_code) {
		this.user_code = user_code;
	}


	public String getPlan_code() {
		return plan_code;
	}


	public void setPlan_code(String plan_code) {
		this.plan_code = plan_code;
	}


	public int getDecoration() {
		return decoration;
	}


	public void setDecoration(int decoration) {
		this.decoration = decoration;
	}


	public int getAdmin() {
		return admin;
	}


	public void setAdmin(int admin) {
		this.admin = admin;
	}


	public int getInternational() {
		return international;
	}


	public void setInternational(int international) {
		this.international = international;
	}


	public String getNotes() {
		return notes;
	}


	public void setNotes(String notes) {
		this.notes = notes;
	}

	public Set<TGH_Recepient> getRecepients() {
		return Recepients;
	}


	public void setRecepients(Set<TGH_Recepient> recepients) {
		Recepients = recepients;
	}

	public void setCall_date(Date call_date) {
		this.call_date = call_date;
	}


	public void setCaller_number(String caller_number) {
		this.caller_number = caller_number;
	}


	public void setCaller_name(String caller_name) {
		this.caller_name = caller_name;
	}


	public void setSend_date(Date send_date) {
		this.send_date = send_date;
	}


	public void setTemplate_flag(int template_flag) {
		this.template_flag = template_flag;
	}


	public void setCode_type_temp(String code_type_temp) {
		this.code_type_temp = code_type_temp;
	}


	public void setTemp_Code(String temp_Code) {
		this.temp_Code = temp_Code;
	}


	public void setDelivery_notice_flag(int delivery_notice_flag) {
		this.delivery_notice_flag = delivery_notice_flag;
	}


	public void setUrgent_flag(int urgent_flag) {
		this.urgent_flag = urgent_flag;
	}


	public void setMessg(String messg) {
		this.messg = messg;
	}


	public void setSenders(Set<Sender> senders) {
		this.senders = senders;
	}
	
	public Set<Sender> getSenders() {
		
		return senders;
	}

	public void ListSenders(Set<Sender> senders) {
		this.senders = senders;
//		this.senders.ge
	}


	
	public Long getthgeneratorid() {
		return thgeneratorid;
	}


	public void setthgeneratorid(Long thgeneratorid) {
		this.thgeneratorid = thgeneratorid;
	}


	public void ListGenerator_id(Long thgeneratorid) {
		this.thgeneratorid = thgeneratorid;
	}

	public Date getCall_date() {
		return call_date;
	}

//	public void ListCall_date(Date call_date) {
//		this.call_date = call_date;
//	}

	public String getCaller_number() {
		return caller_number;
	}

	public void ListCaller_number(String caller_number) {
		this.caller_number = caller_number;
	}

	public String getCaller_name() {
		return caller_name;
	}

	public void ListCaller_name(String caller_name) {
		this.caller_name = caller_name;
	}

	public Date getSend_date() {
		return send_date;
	}

	public void ListSend_date(Date send_date) {
		this.send_date = send_date;
	}

	public int getTemplate_flag() {
		return template_flag;
	}

	public void ListTemplate_flag(int template_flag) {
		this.template_flag = template_flag;
	}

	public String getCode_type_temp() {
		return code_type_temp;
	}

	public void ListCode_type_temp(String code_type_temp) {
		this.code_type_temp = code_type_temp;
	}

	public String getTemp_Code() {
		return temp_Code;
	}

	public void ListTemp_Code(String temp_Code) {
		this.temp_Code = temp_Code;
	}

	public int getDelivery_notice_flag() {
		return delivery_notice_flag;
	}

	public void ListDelivery_notice_flag(int delivery_notice_flag) {
		this.delivery_notice_flag = delivery_notice_flag;
	}

	public int getUrgent_flag() {
		return urgent_flag;
	}

	public void ListUrgent_flag(int urgent_flag) {
		this.urgent_flag = urgent_flag;
	}

	public String getMessg() {
		return messg;
	}

	public void ListMessg(String messg) {
		this.messg = messg;
	}
}
