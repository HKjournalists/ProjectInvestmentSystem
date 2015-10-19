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
		List<Role> rolelist = new ArrayList<Role>();
		
		String names[] = {"风控管理员","合规审核员","信用评级人员","老板","项目经理","傻傻的你","痴痴的我","董事长","合规分析员","系统管理员"};
		
		for(int i = 0 ; i < names.length; i++)
		{
			
			int id = i;
			
			Role role = new Role(((Integer)id).toString(), names[i]);
		
			rolelist.add(role);
		}
		
		return rolelist;
	}

	@Override
	public Role getRoleById(String roleId) {
		// TODO Auto-generated method stub
		
		String names[] = {"风控管理员","合规审核员","信用评级人员","老板","项目经理","傻傻的你","痴痴的我","董事长","合规分析员","系统管理员"};
		
		Role role = new Role(roleId,names[Integer.parseInt(roleId) % names.length]);
		
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
