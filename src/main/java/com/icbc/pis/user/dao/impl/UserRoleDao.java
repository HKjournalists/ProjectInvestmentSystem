package com.icbc.pis.user.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.jbpm.api.IdentityService;
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
	
	@Autowired
	private IdentityService identityService;
	
	@Override 
	public List<UserRole> getALLRoleListByUserId(String userId) {
		// TODO Auto-generated method stub
		
		List<UserRole> urList = null;

			
		String sql = "select * from PIS_USER_ROLE_REL where USER_ID = ?" ;
		
		urList = jdbcTemplate.query(sql ,new Object[] {userId}, new UserRoleMapper() );
		
		return urList;

		
	}

	@Override
	public boolean add(Object obj) {
		// TODO Auto-generated method stub

		UserRole ur = (UserRole)obj;
		
		this.identityService.createMembership(ur.getUserId(), ur.getRoleId());
		
		String sql = "insert into PIS_USER_ROLE_REL(USER_ID,ROLE_ID) values (?,?)";
		
		int affectedRows = this.jdbcTemplate.update(sql,ur.getUserId(),ur.getRoleId());
		
		return affectedRows != 0;
		
	}

	@Override
	public boolean update(Object obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(String id) {
		// TODO Auto-generated method stub
		
		String sql = "delete from PIS_USER_ROLE_REL where USER_ID = ?";
			
		int affectedRows = this.jdbcTemplate.update(sql,id);
			
		return true;
		
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
