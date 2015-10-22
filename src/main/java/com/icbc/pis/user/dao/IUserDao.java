package com.icbc.pis.user.dao;

import java.util.List;
import java.util.Map;

import com.icbc.pis.web.model.User;
import com.icbc.pis.web.model.UserRole;
 
public interface IUserDao {
	
	public String getUserPswdById(String userId);

	public List<User> getAllUserList();
	
	public User getUserById(String userId);
	
	public List<User> getUsersByCondition(Map<String, String[]> filterMap);
	
	public boolean updateUserPswd(String userId, String pswd);

	public int count();
	
}
