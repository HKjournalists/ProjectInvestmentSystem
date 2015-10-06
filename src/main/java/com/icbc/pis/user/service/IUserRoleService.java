package com.icbc.pis.user.service;

import java.util.List;

import com.icbc.pis.web.model.*;
 
public interface IUserRoleService {

	public boolean delSepcificRole(String userId,String roleId);
	
	public List<UserRole> getUserRole(String userId);
}
