package com.icbc.pis.user.service.impl;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.icbc.pis.common.service.ICommonOperService;
import com.icbc.pis.datastruct.UserInfo;
import com.icbc.pis.user.dao.impl.UserDao;
import com.icbc.pis.user.dao.impl.UserRoleDao;
import com.icbc.pis.user.service.IUserService;
import com.icbc.pis.web.model.User;
import com.icbc.pis.web.model.UserRole;
import com.icbc.pis.web.utils.StringUtil;


@Service("UserService")
public class UserService implements ICommonOperService,IUserService  {

	private static final Logger logger = LoggerFactory.getLogger(UserService.class);
	
	@Autowired
	private UserDao userDao;
	
	@Autowired
	private UserRoleDao userRoleDao;
	
	private final String defaultPswd = "111111";
	
	@Override
	public String getUserPwdByUserId(String userId) {
		
		return this.userDao.getUserPswdById(userId);
	}

	@Override
	public User getUserById(String userId) {
		
		return this.userDao.getUserById(userId);
	}

	@Override
	public List<User> getAllUserList() {
		
		return this.userDao.getAllUserList();
	}

	@Override
	public List<User> getUsersByCondition(Map<String, String[]> filterCond) {
		
		return this.userDao.getUsersByCondition(filterCond);
	}


	@Override
	@Transactional
	public boolean add(Object userInfo) {
		
		boolean retFlag = false;
		
		UserInfo userinfo = (UserInfo)userInfo;
		
		for(UserRole ur : userinfo.getRoleList())
		{
			retFlag = this.userRoleDao.add(ur);
			
			if(retFlag == false)
			{
				return retFlag;
			}
		}
		
		retFlag = this.userDao.add(userinfo.getUserBasicInfo());
		
		return retFlag;
	}

	@Override
	@Transactional
	public boolean update(Object userInfo) {
		
		boolean retFlag = false;
		
		UserInfo userinfo = (UserInfo)userInfo;
		
		//retFlag = this.userRoleDao.delete(userinfo.getUserBasicInfo().getUserId());
		
		if(retFlag == false)
		{
			return retFlag;
		}
		
		for(UserRole ur : userinfo.getRoleList())
		{
			retFlag = this.userRoleDao.add(ur);
			
			if(retFlag == false)
			{
				return retFlag;
			}
		}
		
		retFlag = this.userDao.update(userinfo.getUserBasicInfo());
		
		return retFlag;
	}

	@Override
	@Transactional
	public boolean deleteById(String userId) 
	{
		
		boolean retFlag = false;
		
		retFlag = this.userRoleDao.delete(userId);
		
		if(retFlag == false)
		{
			return retFlag;
		}
		
		retFlag = this.userDao.delete(userId);
		
		
		return retFlag;
	}

	@Override
	public boolean isExists(String userId) {
		
		return this.userDao.isExists(userId);
	}

	@Override
	public boolean updateUserPswd(String userId, String pswd) {
		
		return this.userDao.updateUserPswd(userId, pswd);
	}
	
	@Override
	public int count(){
		
		return this.userDao.count();
	}

}
