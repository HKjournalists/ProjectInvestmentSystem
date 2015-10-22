package com.icbc.pis.user.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.icbc.pis.common.dao.ICommonOperDao;
import com.icbc.pis.user.dao.IUserRoleDao;
import com.icbc.pis.user.service.impl.UserService;
import com.icbc.pis.web.mapper.UserMapper;
import com.icbc.pis.web.mapper.UserRoleMapper;
import com.icbc.pis.web.model.User;
import com.icbc.pis.web.model.UserRole;

@Repository("UserRoleDao")
public class UserRoleDao implements IUserRoleDao,ICommonOperDao {
 
	private static final Logger logger = LoggerFactory.getLogger(UserRoleDao.class);
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Override 
	public List<UserRole> getALLRoleListByUserId(String userId) {
		// TODO Auto-generated method stub
		
//		List<UserRole> urList = new ArrayList<UserRole>();
//		
//		urList.add(new UserRole(userId,userId));
//		
//		Integer id = Integer.parseInt(userId) + 1;
//		
//		urList.add(new UserRole(id.toString(),id.toString()));
//		
//		return urList;
		
		List<UserRole> urList = null;
		
		try
		{
			
			String sql = "select  *  from PIS_USER_ROLE_REL where USER_ID = ?" ;
			
			urList = jdbcTemplate.query(sql ,new Object[] {userId}, new UserRoleMapper() );
			
			return urList;
		}
		catch(Exception e)
		{
			return null;
		}
		
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
