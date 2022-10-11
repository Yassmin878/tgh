package com.example.demo.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="TGH_TEMPLATE")
public class TGH_Template 
{
	
	@Id
	@Column(name="TEMP_CODE")
	private String code;
	
	@Column(name="TEMP_TYPE_CODE")
	private String Type_code;
	
	@Column(name="TEMP_NAME")
	private String name;
	
	@Column(name="TEMP_SUBJECT")
	private String subject;

	
	public TGH_Template(String type_code) {
		super();
		Type_code = type_code;
	}

	public TGH_Template() {
		super();
	
	}
	public TGH_Template(String type_code, String name, String subject) {
		super();
		Type_code = type_code;
		this.name = name;
		this.subject = subject;
	}

	public TGH_Template(String code, String type_code, String name, String subject) {
		super();
		this.code = code;
		Type_code = type_code;
		this.name = name;
		this.subject = subject;
	}
	
	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getType_code() {
		return Type_code;
	}

	public void setType_code(String type_code) {
		Type_code = type_code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	
}
