package com.icbc.pis.role.dao.impl;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.icbc.pis.role.dao.IRoleDao;
import com.icbc.pis.web.mapper.RoleMapper;
import com.icbc.pis.web.mapper.UserMapper;
import com.icbc.pis.web.model.Role;
import com.icbc.pis.web.model.User;
 
@Repository("RoleDao")
public class RoleDao implements IRoleDao{

	@Autowired
	private JdbcTemplate jdbcTemplate;

	private static final Logger logger = LoggerFactory
			.getLogger(RoleDao.class);
	
	@Override
	public List<Role> getAllRoleList() {
		// TODO Auto-generated method stub
		List<Role> rolelist = null;
		
		try
		{
			
			String sql = "select  *  from PIS_ROLE t";
			
			rolelist = jdbcTemplate.query(sql , new RoleMapper() );
			
			return rolelist;
		}
		catch(Exception e)
		{
			return null;
		}
		
		 
	}

	@Override
	public Role getRoleById(String roleId) {
		// TODO Auto-generated method stub
		
		String sql = "select * from pis_role where id = ?";
		
		Role role = null;
		
		try 
		{
			role = jdbcTemplate.queryForObject(sql, new Object[] { roleId },
					new RoleMapper());
		}
		catch (Exception e) 
		{
			logger.error("resuly is 0, exception : " + e.toString());
		}
		
		return role;
		
	}

	@Override
	public Role getGroupByActivityName(String activityName) {
		// TODO Auto-generated method stub
		
		String sql = "select ID,NAME,LST_MOD_USER_ID,ROLE_CATEGORY, LST_MOD_TIME from PIS_ACTIVITY_GROUP,PIS_ROLE where group_id = id and activity = ?";
		
		Role activityGrp = null;
		
		try 
		{
			activityGrp = jdbcTemplate.queryForObject(sql, new Object[] { activityName },
					new RoleMapper());
		}
		catch (Exception e) 
		{
			logger.error("resuly is 0, exception : " + e.toString());
		}
		
		return activityGrp;
	}


	
}
