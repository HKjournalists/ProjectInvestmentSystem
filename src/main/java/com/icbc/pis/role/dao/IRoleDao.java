package com.icbc.pis.role.dao;

import java.util.List;

import com.icbc.pis.web.model.Role;

public interface IRoleDao {
	
	public List<Role> getAllRoleList();
	
	public Role getRoleById(String roleId);
	 
}
