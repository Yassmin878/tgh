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
import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name="TGH_RECEPIENT")

public class TGH_Recepient 
{
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator="recepient_SEQ")
	@SequenceGenerator(name = "recepient_SEQ", sequenceName="TGH_RECEPIENT_SEQ1", allocationSize = 1)

	@Column(name="REC_ID")
	private Long recepient_id;
	@Column(name="GEN_ID")
	private Long generator_id;
	@Column(name="REC_NAME")
	//@JsonProperty("rec_name")
	
	private String rec_name;
	@Column(name="REC_TEL_NO")
	private String telephone_number;
	@Column(name="ADDRESS")
	private String address;
	@Column(name="REC_VIP")
	private int  vip;
	
	@ManyToOne
	@JoinColumn(name="GEN_ID",insertable = false,updatable = false)
	@JsonIgnore
	private TGH_Generator gene;
	
//	@ManyToOne
//	@JoinColumn(name="GEN_ID",insertable = false,updatable = false)
//	@JsonIgnore
//	private TGH_Telegraph_model m;
	
	public TGH_Recepient(Long recepient_id, Long generator_id, String rec_name, String telephone_number,
			String address, int vip, TGH_Generator gene) {
		super();
		this.recepient_id = recepient_id;
		this.generator_id = generator_id;
		this.rec_name = rec_name;
		this.telephone_number = telephone_number;
		this.address = address;
		this.vip = vip;
		this.gene = gene;
	}
	
	public TGH_Recepient(Long recepient_id, Long generator_id, String rec_name, String telephone_number,
			String address, int vip) {
		super();
		this.recepient_id = recepient_id;
		this.generator_id = generator_id;
		this.rec_name = rec_name;
		this.telephone_number = telephone_number;
		this.address = address;
		this.vip = vip;
	}
	
	public TGH_Recepient() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Long getRecepient_id() {
		return recepient_id;
	}
	public void setRecepient_id(Long recepient_id) {
		this.recepient_id = recepient_id;
	}
	public Long getGenerator_id() {
		return generator_id;
	}
	public void setGenerator_id(Long generator_id) {
		this.generator_id = generator_id;
	}
	
	public String getRec_name() {
		return rec_name;
	}

	public void setRec_name(String rec_name) {
		this.rec_name = rec_name;
	}

	public String getTelephone_number() {
		return telephone_number;
	}
	public void setTelephone_number(String telephone_number) {
		this.telephone_number = telephone_number;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public int getVips() {
		return vip;
	}
	public void setNotes(int vip) {
		this.vip = vip;
	}

	@Override
	public String toString() {
		return "TGH_Recepient [recepient_id=" + recepient_id + ", generator_id=" + generator_id + ", rec_name="
				+ rec_name + ", telephone_number=" + telephone_number + ", address=" + address + ", vip=" + vip
				+ ", gene=" + gene + "]";
	}
	
	


}
