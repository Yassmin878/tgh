package com.example.demo.secuirty.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="SC_USERROLE", schema = "BPM_ADMINISTRATION")

public class UserRole {


	@Id
	private Long ROLE_ID;
	private Long USER_ID;
	private String LAST_MODIFIED_BY;
	
public UserRole() {}
	
	public UserRole(Long rOLE_ID, Long uSER_ID, String lAST_MODIFIED_BY) {
		super();
		ROLE_ID = rOLE_ID;
		USER_ID = uSER_ID;
		LAST_MODIFIED_BY = lAST_MODIFIED_BY;
	}

	public Long getROLE_ID() {
		return ROLE_ID;
	}

	public void setROLE_ID(Long rOLE_ID) {
		ROLE_ID = rOLE_ID;
	}

	public Long getUSER_ID() {
		return USER_ID;
	}

	public void setUSER_ID(Long uSER_ID) {
		USER_ID = uSER_ID;
	}

	public String getLAST_MODIFIED_BY() {
		return LAST_MODIFIED_BY;
	}

	public void setLAST_MODIFIED_BY(String lAST_MODIFIED_BY) {
		LAST_MODIFIED_BY = lAST_MODIFIED_BY;
	}

	@Override
	public String toString() {
		return "UserRole [ROLE_ID=" + ROLE_ID + ", USER_ID=" + USER_ID + ", LAST_MODIFIED_BY=" + LAST_MODIFIED_BY + "]";
	}
	
	
	
}
