package com.icbc.pis.web.model;

import java.sql.Timestamp;

public class Role implements java.io.Serializable {
	
	//Private Fields
	
	private String roleId;
	
	private String roleName;
	
	private Timestamp lastModifyTime;
	
	private String lastModifyUserId;

	private String roleCategory;
	
	
	public Role(String roleId,String roleName)
	{
		this.roleId = roleId;
		
		this.roleName = roleName;
	}
	
	public Role(String roleId,String roleName,String lastModifyUserId,String roleCategory,Timestamp lastModifyTime)
	{
		this.roleId = roleId;
		
		this.roleName = roleName;
		
		this.lastModifyTime = lastModifyTime;
		
		this.lastModifyUserId = lastModifyUserId;
		
		this.roleCategory = roleCategory;
	}
	
	private Role()
	{}

	public String getRoleId() {
		return roleId;
	}

	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public Timestamp getLastModifyTime() {
		return lastModifyTime;
	}

	public void setLastModifyTime(Timestamp lastModifyTime) {
		this.lastModifyTime = lastModifyTime;
	}

	public String getLastModifyUserId() {
		return lastModifyUserId;
	}

	public void setLastModifyUserId(String lastModifyUserId) {
		this.lastModifyUserId = lastModifyUserId;
	}

	public String getRoleCategory() {
		return roleCategory;
	}

	public void setRoleCategory(String roleCategory) {
		this.roleCategory = roleCategory;
	}
	
	
 
}
