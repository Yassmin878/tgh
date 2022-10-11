package com.example.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "TGH_TEMPLATE_TYPE")

public class TGH_TemplateType 
{
	@Id
//	@GeneratedValue(strategy = GenerationType.SEQUENCE)
//	@SequenceGenerator(name = "Code_SEQ", allocationSize = 1)
	
	@Column(name="TEMP_TYPE_CODE")
	private String code;
	
	@Column(name="TEMP_TYPE_NAME")
	private String name;
	
	
	public TGH_TemplateType(String name) {
		super();
		this.name = name;
	}
	public TGH_TemplateType(String code, String name) {
		super();
		this.code = code;
		this.name = name;
	}
	public TGH_TemplateType() {
		super();
	}
	
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	

}
