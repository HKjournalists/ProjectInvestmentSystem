package com.icbc.pis.role.service;

import java.util.List;

import com.icbc.pis.web.model.Role;
import com.icbc.pis.web.model.User;

public interface IRoleService {

	public List<Role> getAllRoleList();
	
	public Role getRoleById(String roleId);
	
	public List<Role> getRoles(List<String> roleIdList);
	
	public Role getGroupByActivityName(String activityName);
}
