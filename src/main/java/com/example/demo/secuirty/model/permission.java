package com.example.demo.secuirty.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;



@Entity
@Table(name="SC_USER_PERMISSION", schema = "BPM_ADMINISTRATION")
@IdClass(UserPermissionId.class)
public class permission {

	@Id
	private Long USER_ID;
	@Id
	private Long PERMISSION_ID;
	@Id
	private Long MODULE_ID;
	private String USER_NAME;
	private String PERMISSION_NAME;
	public Long getUSER_ID() {
		return USER_ID;
	}
	public void setUSER_ID(Long uSER_ID) {
		USER_ID = uSER_ID;
	}
	public Long getPERMISSION_ID() {
		return PERMISSION_ID;
	}
	public void setPERMISSION_ID(Long pERMISSION_ID) {
		PERMISSION_ID = pERMISSION_ID;
	}
	public Long getMODULE_ID() {
		return MODULE_ID;
	}
	public void setMODULE_ID(Long mODULE_ID) {
		MODULE_ID = mODULE_ID;
	}
	public String getUSER_NAME() {
		return USER_NAME;
	}
	public void setUSER_NAME(String uSER_NAME) {
		USER_NAME = uSER_NAME;
	}
	public String getPERMISSION_NAME() {
		return PERMISSION_NAME;
	}
	public void setPERMISSION_NAME(String pERMISSION_NAME) {
		PERMISSION_NAME = pERMISSION_NAME;
	}
	public permission() {
		super();
		// TODO Auto-generated constructor stub
	}
	public permission(Long uSER_ID, Long pERMISSION_ID, Long mODULE_ID, String uSER_NAME, String pERMISSION_NAME) {
		super();
		USER_ID = uSER_ID;
		PERMISSION_ID = pERMISSION_ID;
		MODULE_ID = mODULE_ID;
		USER_NAME = uSER_NAME;
		PERMISSION_NAME = pERMISSION_NAME;
	}
	 
}
