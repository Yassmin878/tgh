package com.example.demo.model;


import java.time.LocalDate;
import java.util.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
//import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
//import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
//import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;


import org.springframework.lang.NonNull;
//import org.springframework.validation.annotation.Validated;

//import com.fasterxml.jackson.annotation.JacksonInject.Value;
import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Builder;

@Entity
@Table(name="TGH_TELEGRAPH")
@Builder
public class TGH_Telegraph_model {

	
	@ Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator ="id_SEQ" )
	@SequenceGenerator(name = "id_SEQ", sequenceName="TGH_TELEGRAPH_SEQ",  allocationSize = 1)
	
	@Column(name="TGH_ID",updatable = false)
	private Long id;
	
	@Column(name="GEN_ID")
	private Long gen_id;

	//***********************************
	@Column(name="SENDER_NAME")
	private String sendername;
	//***********************************
	@Column(name="REC_NAME")
	private String rec_name ;
	@Column(name="TGH_CODE")
	private String tgh_code;
	@Column(name="USER_CODE")
	private String user_code;
	@Column(name="SEQ_NO")
	private int  seq_no;
	@Column(name="CALLER_NAME")
	private String caller_name;
	@Column(name="PLAN_CODE")
	private String  plan_code;
	@Column(name="DELIVERY_NOTICE")
	private int  delv_notice;
	@Column(name="DECORATION")
	private int  decoration;
	@Column(name="URGENT")
	private int urgent;
	@Column(name="ADMIN")
	private int  admin;
	@Column(name="INTERNATIONAL")
	private int international;
	@Column(name="TEMPLATE")
	private int temp;
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
	@Column(name="SEND_DATE")
	private Date send_date;
	@Column(name="COUNTRY_CODE")
	private String country_code;
	@Column(name="MESSAGE")
	private String mess;
	@Column(name="REDIRECTED")
	private int redirect;
	@Column(name="GENERATED_BY")
	private String gene_by;
	
	@NonNull
	@Size(max = 20,message = "{javax.validation.constraints.Size.very long}")
	@Column(name="STATUS_CODE",updatable = true )
	private String status_code="new";
	
	@NonNull
	@Size(max = 200,message = "{javax.validation.constraints.Size.very long}")
	@Column(name="ADDRESS",updatable = true )
	private String address;
	

    @Size(max = 500,message = "{javax.validation.constraints.Size.very long}")
	@Column(name="NOTES",updatable = true )
	private String notes;
	
	@NonNull
//    @Size(max = 100,message = "{javax.validation.constraints.Size.very long}")
//	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")

	@Column(name="TGH_DATE" )
	private Date  tgh_date;
	
//	@OneToMany(mappedBy="mod",fetch = FetchType.EAGER)
//	private Set<Sender> senders;
//	
//	@OneToMany(mappedBy="m",fetch = FetchType.EAGER)
//	private Set<TGH_Recepient> Recepients;
	
	@Min(value = 0)
	@Column(name="TGH_COST")
	 private String cost;
	
//	TGH_Telegraph_model t=TGH_Telegraph_model.builder();

public TGH_Telegraph_model(Long id, Long gen_id, String sendername, String rec_name, String tgh_code, String user_code,
		int seq_no, String caller_name, String plan_code, int delv_notice, int decoration, int urgent, int admin,
		int international, int temp, Date send_date, String country_code, String mess, int redirect, String gene_by,String status_code,
		String address, String notes,
		Date tgh_date) {
	super();
	this.id = id;
	this.gen_id = gen_id;
	this.sendername = sendername;
	this.rec_name = rec_name;
	this.tgh_code = tgh_code;
	this.user_code = user_code;
	this.seq_no = seq_no;
	this.caller_name = caller_name;
	this.plan_code = plan_code;
	this.delv_notice = delv_notice;
	this.decoration = decoration;
	this.urgent = urgent;
	this.admin = admin;
	this.international = international;
	this.temp = temp;
	this.send_date = send_date;
	this.country_code = country_code;
	this.mess = mess;
	this.redirect = redirect;
	this.gene_by = gene_by;
	this.status_code =status_code;
	this.address = address;
	this.notes = notes;
	this.tgh_date =tgh_date;
}
/***
//public TGH_Telegraph_model(Long id, Long gen_id, String sendername, String rec_name, String tgh_code, String user_code,
//		int seq_no, String caller_name, String plan_code, int delv_notice, int decoration, int urgent, int admin,
//		int international, int temp, Date send_date, String country_code, String mess, int redirect, String gene_by,
//		String address, String notes, Date tgh_date) {
//	super();
//	this.id = id;
//	this.gen_id = gen_id;
//	this.sendername = sendername;
//	this.rec_name = rec_name;
//	this.tgh_code = tgh_code;
//	this.user_code = user_code;
//	this.seq_no = seq_no;
//	this.caller_name = caller_name;
//	this.plan_code = plan_code;
//	this.delv_notice = delv_notice;
//	this.decoration = decoration;
//	this.urgent = urgent;
//	this.admin = admin;
//	this.international = international;
//	this.temp = temp;
//	this.send_date = send_date;
//	this.country_code = country_code;
//	this.mess = mess;
//	this.redirect = redirect;
//	this.gene_by = gene_by;
//	this.status_code = "NEW";
//	this.address = address;
//	this.notes = notes;
//	this.tgh_date = Date.now();
//}
 */

public TGH_Telegraph_model() {
	super();
	//this.tgh_date=Date.now();
	this.status_code = "NEW";
//	this.address=Recepients
}

//public Set<Sender> getSenders() {
//	return senders;
//}

public TGH_Telegraph_model(Long id, Long gen_id, String sendername, String rec_name, String tgh_code, String user_code,
		int seq_no, String caller_name, String plan_code, int delv_notice, int decoration, int urgent, int admin,
		int international, int temp, Date send_date, String country_code, String mess, int redirect, String gene_by,
		@Size(max = 20, message = "{javax.validation.constraints.Size.very long}") String status_code,
		@Size(max = 200, message = "{javax.validation.constraints.Size.very long}") String address,
		@Size(max = 500, message = "{javax.validation.constraints.Size.very long}") String notes, Date tgh_date,
		@Min(0) String cost) {
	super();
	this.id = id;
	this.gen_id = gen_id;
	this.sendername = sendername;
	this.rec_name = rec_name;
	this.tgh_code = tgh_code;
	this.user_code = user_code;
	this.seq_no = seq_no;
	this.caller_name = caller_name;
	this.plan_code = plan_code;
	this.delv_notice = delv_notice;
	this.decoration = decoration;
	this.urgent = urgent;
	this.admin = admin;
	this.international = international;
	this.temp = temp;
	this.send_date = send_date;
	this.country_code = country_code;
	this.mess = mess;
	this.redirect = redirect;
	this.gene_by = gene_by;
	this.status_code = status_code;
	this.address = address;
	this.notes = notes;
	this.tgh_date = tgh_date;
	this.cost = cost;
}
//public void setSenders(Set<Sender> senders) {
//	this.senders = senders;
//}
//
//public Set<TGH_Recepient> getRecepients() {
//	return Recepients;
//}
//
//public void setRecepients(Set<TGH_Recepient> recepients) {
//	Recepients = recepients;
//}

public String getMess() {
	return mess;
}


public void setMess(String mess) {
	this.mess = mess;
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
public String getSendername() {
	return sendername;
}
public void setSendername(String sendername) {
	this.sendername = sendername;
}
public String getRec_name() {
	return rec_name;
}
public void setRec_name(String rec_name) {
	this.rec_name = rec_name;
}
public String getTgh_code() {
	return tgh_code;
}
public void setTgh_code(String tgh_code) {
	this.tgh_code = tgh_code;
}
public String getUser_code() {
	return user_code;
}

public String getCost() {
	return cost;
}
public void setCost(String cost) {
	this.cost = cost;
}
public void setUser_code(String user_code) {
	this.user_code = user_code;
}
public int getSeq_no() {
	return seq_no;
}
public void setSeq_no(int seq_no) {
	this.seq_no = seq_no;
}
public String getCaller_name() {
	return caller_name;
}
public void setCaller_name(String caller_name) {
	this.caller_name = caller_name;
}
public String getPlan_code() {
	return plan_code;
}
public void setPlan_code(String plan_code) {
	this.plan_code = plan_code;
}
public int getDelv_notice() {
	return delv_notice;
}
public void setDelv_notice(int delv_notice) {
	this.delv_notice = delv_notice;
}
public int getDecoration() {
	return decoration;
}
public void setDecoration(int decoration) {
	this.decoration = decoration;
}
public int getUrgent() {
	return urgent;
}
public void setUrgent(int urgent) {
	this.urgent = urgent;
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
public int getTemp() {
	return temp;
}
public void setTemp(int temp) {
	this.temp = temp;
}
public Date getSend_date() {
	return send_date;
}
public void setSend_date(Date send_date) {
	this.send_date = send_date;
}
public String getCountry_code() {
	return country_code;
}
public void setCountry_code(String country_code) {
	this.country_code = country_code;
}
public int getRedirect() {
	return redirect;
}
public void setRedirect(int redirect) {
	this.redirect = redirect;
}
public String getGene_by() {
	return gene_by;
}
public void setGene_by(String gene_by) {
	this.gene_by = gene_by;
}
public String getStatus_code() {
	return status_code;
}
public void setStatus_code(String status_code) {
	this.status_code = status_code;
}
public String getAddress() {
	return address;
}
public void setAddress(String address) {
	this.address = address;
}
public String getNotes() {
	return notes;
}
public void setNotes(String notes) {
	this.notes = notes;
}
public Date getTgh_date() {
	return tgh_date;
}
public void setTgh_date(Date tgh_date) {
	this.tgh_date = tgh_date;
}


}
