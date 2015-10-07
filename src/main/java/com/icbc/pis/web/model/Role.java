package com.icbc.pis.web.model;

public class Role implements java.io.Serializable {
	
	//Private Fields
	
	private String roleId;
	
	private String roleName;
	
	private String desc;


	public Role(String roleId,String roleName,String desc)
	{
		this.roleId = roleId;
		
		this.roleName = roleName;
		
		this.desc = desc;
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
	
	
	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}
}
