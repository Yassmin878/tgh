package com.example.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="TGH_SENDER")
public class Sender 
{
	@Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="sender_sequence")
    @SequenceGenerator(name = "sender_sequence", sequenceName="TGH_SENDER_SEQ",  allocationSize = 1)
	@Column(name="SENDER_ID")
	private Long sender_id;
	@Column(name="GEN_ID")
	private Long generation_id;
	
	@Column(name="SENDER_NAME")
	private String sender_name;
	
	@Column(name="BILL_TEL_NO")
	private String tel_num;

	@Column(name="NOTES")
	private String notes;
//
@ManyToOne(fetch = FetchType.EAGER)
@JoinColumn(name="GEN_ID",insertable = false,updatable = false)
@JsonIgnore
private TGH_Generator thg;


	public Sender(Long sender_id, Long generation_id, String sender_name, String tel_num, String notes,
		TGH_Generator thg) {
	super();
	this.sender_id = sender_id;
	this.generation_id = generation_id;
	this.sender_name = sender_name;
	this.tel_num = tel_num;
	this.notes = notes;
	this.thg = thg;
}
	//***********************************0
	
//
//@ManyToOne
//@JoinColumn(name="GEN_ID",insertable = false,updatable = false)
//@JsonIgnore
//private TGH_Telegraph_model mod;

	public Sender() {
		super();
//		sender_name=thg.getCaller_name();
//		tel_num=thg.getCaller_number();
		
	}
	
	public Sender(Long sender_id, Long generation_id, String sender_name, String tel_num, String notes,
			TGH_Generator thg, TGH_Telegraph_model mod) {
		super();
		this.sender_id = sender_id;
		this.generation_id = generation_id;
		this.sender_name = sender_name;
		this.tel_num = tel_num;
		this.notes = notes;
	}
	public Long getSender_id() {
		return sender_id;
	}
	public void setSender_id(Long sender_id) {
		this.sender_id = sender_id;
	}
	public Long getGeneration_id() {
		return generation_id;
	}
	public void setGeneration_id(Long generation_id) {
		this.generation_id = generation_id;
	}
	

	public String getSender_name() {
		return sender_name;
	}

	public void setSender_name(String sender_name) {
		this.sender_name = sender_name;
	}

	public String getTel_num() {
		return tel_num;
	}
	public void setTel_num(String tel_num) {
		this.tel_num = tel_num;
	}
//	public String getNotes() {
//		return notes;
//	}
//	public void setNotes(String notes) {

	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}


}
