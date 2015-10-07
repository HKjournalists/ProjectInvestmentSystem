package com.icbc.pis.user.service.impl;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.icbc.pis.common.service.ICommonOperService;
import com.icbc.pis.user.dao.impl.UserDao;
import com.icbc.pis.user.service.IUserService;
import com.icbc.pis.web.model.User;
import com.icbc.pis.web.model.UserRole;
import com.icbc.pis.web.utils.StringUtil;


@Service("UserService")
public class UserService implements ICommonOperService,IUserService  {

	private static final Logger logger = LoggerFactory.getLogger(UserService.class);
	
	@Autowired
	private UserDao userDao;
	
	@Override
	public String getUserPwdByUserId(String userId) {
		
		// TODO Auto-generated method stub
		return this.userDao.getUserPswdById(userId);
	}

	@Override
	public User getUserById(String userId) {
		
		// TODO Auto-generated method stub
		return this.userDao.getUserById(userId);
	}

	@Override
	public List<User> getAllUserList() {
		
		// TODO Auto-generated method stub
		return this.userDao.getAllUserList();
	}

	@Override
	public List<User> getUsersByCondition(Map<String, String[]> filterCond) {
		
		// TODO Auto-generated method stub
		return this.userDao.getUsersByCondition(filterCond);
	}


	@Override
	public boolean add(Object user) {
		
		// TODO Auto-generated method stub
		User cast_user = (User)user;
		if(StringUtil.isNullOrEmpty(cast_user.getPswd()))
		{
			return false;
		}
		
		return this.userDao.add(user);
	}

	@Override
	public boolean update(Object user) {
		
		// TODO Auto-generated method stub
		User cast_user = (User)user;
		return this.userDao.update(cast_user);
	}

	@Override
	public boolean deleteById(String userId) {
		
		// TODO Auto-generated method stub
		return this.userDao.delete(userId);
	}

	@Override
	public boolean isExists(String userId) {
		
		// TODO Auto-generated method stub
		return this.userDao.isExists(userId);
	}

	@Override
	public boolean updateUserPswd(String userId, String pswd) {
		
		// TODO Auto-generated method stub
		return this.userDao.updateUserPswd(userId, pswd);
	}
	
	@Override
	public int count(){
		
		return this.userDao.count();
	}

}
