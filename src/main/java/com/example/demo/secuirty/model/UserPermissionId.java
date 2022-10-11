package com.example.demo.secuirty.model;

import java.io.Serializable;
import java.util.Objects;



//implements Serializable
public class UserPermissionId implements Serializable{
	private Long USER_ID;
	private Long PERMISSION_ID;
	private Long MODULE_ID;
	public UserPermissionId(Long uSER_ID, Long pERMISSION_ID, Long mODULE_ID) {
		super();
		USER_ID = uSER_ID;
		PERMISSION_ID = pERMISSION_ID;
		MODULE_ID = mODULE_ID;
	}
	public UserPermissionId() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Long getUSER_ID() {
		return USER_ID;
	}
	public Long getPERMISSION_ID() {
		return PERMISSION_ID;
	}
	public Long getMODULE_ID() {
		return MODULE_ID;
	}
	

	@Override
	public int hashCode() {
		return Objects.hash(MODULE_ID, PERMISSION_ID, USER_ID);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UserPermissionId other = (UserPermissionId) obj;
		return Objects.equals(MODULE_ID, other.MODULE_ID) && Objects.equals(PERMISSION_ID, other.PERMISSION_ID)
				&& Objects.equals(USER_ID, other.USER_ID);
	}
	
}
