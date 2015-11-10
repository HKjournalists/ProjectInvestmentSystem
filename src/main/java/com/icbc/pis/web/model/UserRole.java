package com.icbc.pis.web.model;

public class UserRole implements java.io.Serializable {

	private String userId;
	
	private String roleId;
	
	public UserRole(String userId, String roleId)
	{
		this.userId = userId;
		
		this.roleId = roleId;
	}

	public String getUserId() {
		return this.userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getRoleId() {
		return this.roleId;
	}

	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}
	
	
}
