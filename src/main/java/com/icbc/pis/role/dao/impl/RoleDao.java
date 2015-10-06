package com.icbc.pis.role.dao.impl;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.icbc.pis.role.dao.IRoleDao;
import com.icbc.pis.web.model.Role;
import com.icbc.pis.web.model.User;

@Repository("RoleDao")
public class RoleDao implements IRoleDao{

	@Override
	public List<Role> getAllRoleList() {
		// TODO Auto-generated method stub
		List<Role> rolelist = new ArrayList<Role>();
		
		String names[] = {"风控管理员","合规审核员","信用评级人员","老板","项目经理","傻傻的你","痴痴的我","董事长","合规分析员","系统管理员"};
		
		for(int i = 0 ; i < names.length; i++)
		{
			
			int id = i;
			
			Role role = new Role(((Integer)id).toString(), names[i], names[i] );
		
			rolelist.add(role);
		}
		
		return rolelist;
	}
	
	
}
