package com.example.demo.secuirty.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Proxy;

@Entity
@Table(name = "SC_ROLES", schema = "BPM_ADMINISTRATION")
@Proxy(lazy=false)
public class Role {
	@Id
	@Column(name = "ROLE_ID")
	private Long role_ID;
	@Column(name = "ROLE_NAME")
	private String role_NAME;
	@Column(name = "PARENT_ROLE_ID")
	private Long parent_Role_ID;
	@Column(name = "LAST_MODIFIED_BY")
	private String last_MODIFIED_BY;
	public Role(Long role_ID, String role_NAME, Long parent_Role_ID, String last_MODIFIED_BY) {
		super();
		this.role_ID = role_ID;
		this.role_NAME = role_NAME;
		this.parent_Role_ID = parent_Role_ID;
		this.last_MODIFIED_BY = last_MODIFIED_BY;
	}
	public Role() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Long getRole_ID() {
		return role_ID;
	}
	public void setRole_ID(Long role_ID) {
		this.role_ID = role_ID;
	}
	public String getRole_NAME() {
		return role_NAME;
	}
	public void setRole_NAME(String role_NAME) {
		this.role_NAME = role_NAME;
	}
	public Long getParent_Role_ID() {
		return parent_Role_ID;
	}
	public void setParent_Role_ID(Long parent_Role_ID) {
		this.parent_Role_ID = parent_Role_ID;
	}
	public String getLast_MODIFIED_BY() {
		return last_MODIFIED_BY;
	}
	public void setLast_MODIFIED_BY(String last_MODIFIED_BY) {
		this.last_MODIFIED_BY = last_MODIFIED_BY;
	}
	
	
}
