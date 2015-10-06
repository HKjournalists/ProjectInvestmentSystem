package com.icbc.pis.user.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.icbc.pis.common.service.ICommonOperService;
import com.icbc.pis.user.dao.impl.UserRoleDao;
import com.icbc.pis.user.service.IUserRoleService;
import com.icbc.pis.web.model.UserRole;

@Service("UserRoleService")
public class UserRoleService implements IUserRoleService,ICommonOperService {

	@Autowired
	private UserRoleDao userRoleDao;


	@Override
	public boolean delSepcificRole(String userId, String roleId) {
		// TODO Auto-generated method stub
		return this.userRoleDao.delSepcificRole(userId, roleId);
	}

	@Override
	public List<UserRole> getUserRole(String userId) {
		// TODO Auto-generated method stub
		return this.userRoleDao.getALLRoleListByUserId(userId);
	}

	@Override
	public boolean add(Object obj) {
		// TODO Auto-generated method stub
		return this.userRoleDao.add((UserRole)obj);
	}

	@Override
	public boolean update(Object obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteById(String userId) {
		// TODO Auto-generated method stub
		return this.userRoleDao.delete(userId);
	}

	@Override
	public boolean isExists(String id) {
		// TODO Auto-generated method stub
		return false;
	}

}
