package com.icbc.pis.user.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.icbc.pis.common.dao.ICommonOperDao;
import com.icbc.pis.user.dao.IUserRoleDao;
import com.icbc.pis.web.model.UserRole;

@Repository("UserRoleDao")
public class UserRoleDao implements IUserRoleDao,ICommonOperDao {
 
	@Override 
	public List<UserRole> getALLRoleListByUserId(String userId) {
		// TODO Auto-generated method stub
		
		List<UserRole> urList = new ArrayList<UserRole>();
		
		urList.add(new UserRole(userId,userId));
		
		Integer id = Integer.parseInt(userId) + 1;
		
		urList.add(new UserRole(id.toString(),id.toString()));
		
		return urList;
	}

	@Override
	public boolean add(Object obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(Object obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(String id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isExists(String id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delSepcificRole(String userId, String RoleId) {
		// TODO Auto-generated method stub
		return false;
	}

 

}
