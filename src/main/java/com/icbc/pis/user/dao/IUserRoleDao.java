package com.icbc.pis.user.dao;

import java.util.List;

import com.icbc.pis.web.model.UserRole;

public interface IUserRoleDao {

	public List<UserRole> getALLRoleListByUserId(String userId);
	
	public boolean delSepcificRole(String userId,String RoleId);

}
