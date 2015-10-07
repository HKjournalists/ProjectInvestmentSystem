package com.icbc.pis.user.service;

import java.util.List;
import java.util.Map;

import com.icbc.pis.web.model.User;
import com.icbc.pis.web.model.UserRole;

public interface IUserService {

	public String getUserPwdByUserId(String userId);
	
	public User getUserById(String userId);
	 
	public List<User> getAllUserList();

	public List<User> getUsersByCondition(Map<String,String[]> filterMap);

	public boolean updateUserPswd(String userId,String pswd);

	public int count();
}
