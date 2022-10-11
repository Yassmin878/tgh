package com.example.demo.secuirty.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name="SC_USERS", schema = "BPM_ADMINISTRATION")
public class user 
{	
	@Id
	@Column(name = "USER_ID")
	private long user_id;
	@Column(name ="USER_NAME")
	private String user_name;
	@Column(name ="DISPLAY_NAME")
	private String display_name;
	@Column(name ="USER_PASSWORD")
	private String password;
	@Column(name ="USER_TYPE")
	private String user_type;
	private String PASSWORD_ENC;
	private Integer ENABLED;
	private Integer ACTIVE;
	private String LAST_MODIFIED_BY;
	private Long ORG_UNIT_ID;
	
	public user(long user_id, String user_name, String display_name, String password, String user_type,
			String pASSWORD_ENC, Integer eNABLED, Integer aCTIVE, String lAST_MODIFIED_BY, Long oRG_UNIT_ID,
			List<Role> roles, List<permission> permissions) {
		super();
		this.user_id = user_id;
		this.user_name = user_name;
		this.display_name = display_name;
		this.password = password;
		this.user_type = user_type;
		PASSWORD_ENC = pASSWORD_ENC;
		ENABLED = eNABLED;
		ACTIVE = aCTIVE;
		LAST_MODIFIED_BY = lAST_MODIFIED_BY;
		ORG_UNIT_ID = oRG_UNIT_ID;
		this.roles = roles;
		this.permissions = permissions;
	}
	@Transient
	private List<Role> roles;   
	
	@Transient
	private List<permission> permissions;

	public user(long user_id, String user_name, String display_name, String password, String user_type,
			List<com.example.demo.secuirty.model.Role> roles, List<permission> permissions) {
		super();
		this.user_id = user_id;
		this.user_name = user_name;
		this.display_name = display_name;
		this.password = password;
		this.user_type = user_type;
		this.roles = roles;
		this.permissions = permissions;
	}
	public List<String> getRoles() {
		List<String> rolesStrings = new ArrayList<String>();
		roles.forEach( role -> {
			rolesStrings.add(role.getRole_NAME());
		});
		
		return rolesStrings;
	}

	public Integer getENABLED() {
		return ENABLED;
	}

	public void setENABLED(Integer eNABLED) {
		ENABLED = eNABLED;
	}

	public Integer getACTIVE() {
		return ACTIVE;
	}

	public void setACTIVE(Integer aCTIVE) {
		ACTIVE = aCTIVE;
	}
	public String getPASSWORD_ENC() {
		return PASSWORD_ENC;
	}

	public void setPASSWORD_ENC(String pASSWORD_ENC) {
		PASSWORD_ENC = pASSWORD_ENC;
	}

	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}
	public List<permission> getPermissions() {
		return permissions;
	}
	public void setPermissions(List<permission> permissions) {
		this.permissions = permissions;
	}
	public user(long user_id, String user_name, String display_name, String password, String user_type) {
		super();
		this.user_id = user_id;
		this.user_name = user_name;
		this.display_name = display_name;
		this.password = password;
		this.user_type = user_type;
	}
	public user() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public List<String> getPermissionsStrings() {
		
		List<String> permissionsStrings = new ArrayList<String>();
		permissions.forEach( permission -> {
			permissionsStrings.add(permission.getPERMISSION_NAME());
		});
		
		return permissionsStrings;
	}

	
	
	public long getUser_id() {
		return user_id;
	}
	public void setUser_id(long user_id) {
		this.user_id = user_id;
	}
	public String getUser_name() {
		return user_name;
	}
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	public String getDisplay_name() {
		return display_name;
	}
	public void setDisplay_name(String display_name) {
		this.display_name = display_name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getUser_type() {
		return user_type;
	}
	public void setUser_type(String user_type) {
		this.user_type = user_type;
	}
}
