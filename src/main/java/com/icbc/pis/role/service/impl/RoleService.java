package com.icbc.pis.role.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.icbc.pis.role.dao.impl.RoleDao;
import com.icbc.pis.role.service.IRoleService;
import com.icbc.pis.user.dao.impl.UserDao;
import com.icbc.pis.web.model.Role;

@Service("RoleService")
public class RoleService implements IRoleService{

	@Autowired
	private RoleDao roleDao;
	
	@Override
	public List<Role> getAllRoleList() {
		// TODO Auto-generated method stub
		return this.roleDao.getAllRoleList();
	}

	@Override
	public Role getRoleById(String roleId) {
		// TODO Auto-generated method stub
		return this.roleDao.getRoleById(roleId);
	}

	@Override
	public List<Role> getRoles(List<String> roleIdList) {
		// TODO Auto-generated method stub
		List<Role> roleList = new ArrayList<Role>();
		
		for(String roleId : roleIdList)
		{
			Role role = this.roleDao.getRoleById(roleId);
			
			roleList.add(role);
		}
		
		return roleList;
	}

	
}
