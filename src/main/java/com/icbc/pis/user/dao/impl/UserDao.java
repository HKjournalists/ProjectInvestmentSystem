package com.icbc.pis.user.dao.impl;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.jbpm.api.IdentityService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapperResultSetExtractor;
import org.springframework.stereotype.Repository;

import com.icbc.pis.common.dao.ICommonOperDao;
import com.icbc.pis.user.dao.IUserDao;
import com.icbc.pis.user.service.impl.UserService;
import com.icbc.pis.util.StringUtil;
import com.icbc.pis.web.mapper.UserMapper;
import com.icbc.pis.web.model.User;
import com.icbc.pis.web.model.UserRole;
@Repository("UserDao")
public class UserDao implements IUserDao,ICommonOperDao{

	private static final Logger logger = LoggerFactory.getLogger(UserDao.class);
	
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Autowired
	private IdentityService identityService;
	
	@Override
	public List<User> getAllUserList() {
		// TODO Auto-generated method stub
		
		return null;
	}

	@Override
	public User getUserById(String userId) {
		
		try
		{
			logger.debug("begin getUserById");
			
			String sql = "select * from pis_user where status = 1 and id=?";
			
			User user = this.jdbcTemplate.queryForObject(sql, new Object[] { userId }, new UserMapper());
			
			logger.debug("end getUserById");
			
			return user;
		}
		catch(Exception e)
		{
			logger.error(e.toString());
			
			return null;
		}
	}

	@Override
	public String getUserPswdById(String userId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean updateUserPswd(String userId, String pswd) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean add(Object obj) 
	{

		try
		{
			User user = (User) obj;
			
			String sql = "insert into PIS_USER(ID,NAME,STATUS,EXT,EMAIL,MOBILE,CARD_TYPE,CARD_NO,MODI_USER,MODI_TIME)" + 
						 "values(?,?,?,?,?,?,?,?,?,?)";
			
			int affectedRows = this.jdbcTemplate.update(sql,user.getId(),user.getName(),user.getStatus(),user.getExt(),user.getEmail(),user.getMobile(),user.getCardType(),user.getCardNo(),user.getModiUser(),user.getModiTime());
			
			this.identityService.createUser(user.getId(), user.getName(), "");
			
			return affectedRows != 0;
		}
		catch(Exception e)
		{
			logger.error(e.toString());
			
			return false;
		}
	}

	@Override
	public boolean update(Object obj) {

		try
		{
			User user = (User) obj;
			
			String sql = "update PIS_USER set NAME = ?,STATUS = ?,EXT = ?,EMAIL = ?,MOBILE = ?,CARD_TYPE = ?,CARD_NO = ?,MODI_USER = ?,MODI_TIME = ?" + 
						 " where ID = ?";
			
			int affectedRows = this.jdbcTemplate.update(sql,user.getName(),user.getStatus(),user.getExt(),user.getEmail(),user.getMobile(),user.getCardType(),user.getCardNo(),user.getModiUser(),user.getModiTime(),user.getId());
			
			return affectedRows != 0;
		}
		catch(Exception e)
		{
			logger.error(e.toString());
			
			return false;
		}
		
	}

	@Override
	public boolean delete(String id) {
		// TODO Auto-generated method stub
		
		try
		{
			String sql = "update PIS_USER set STATUS = 2 where ID = ?";
			
			int affectedRows = this.jdbcTemplate.update(sql, id);
			
			return affectedRows != 0;
		}
		catch(Exception e)
		{
			logger.error(e.toString());
			
			return false;
		}
	}

	@Override
	public boolean isExists(String id) {
		
		try
		{
			int cnt = this.jdbcTemplate.queryForObject("select count(*) from PIS_USER where status = 1 and id = ?",new Object[] {id}, Integer.class);
			
			return cnt > 0 ? true : false;
		}
		catch(Exception e)
		{
			logger.error(e.toString());
			
			return false;
		}
	}

	@Override
	public int count(){
		
		try
		{
		
			int cnt = this.jdbcTemplate.queryForObject("select count(*) from PIS_USER where STATUS = 1", Integer.class);
		
			return cnt;
		}
		catch(Exception e)
		{
			logger.error(e.toString());
			
			return 0;
		}
	}
	
	@Override
	public List<User> getUsersByCondition(Map<String, String[]> filterMap) {
		// TODO Auto-generated method stub
		
		Integer iStart = Integer.parseInt(StringUtil.getFirst(filterMap.get("start"))) + 1;
		
		String number = StringUtil.getFirst(filterMap.get("number"));
		
		Integer iEnd = iStart + Integer.parseInt(number) - 1;
		
		String end = iEnd.toString();
		
		String start = iStart.toString();
		
		String name = StringUtil.getFirst(filterMap.get("name")) ;
		
		String id = StringUtil.getFirst(filterMap.get("id"));
		
		try
		{
			String sql = " select p.ID,p.NAME,p.STATUS,p.EXT,p.EMAIL,p.MOBILE,p.CARD_TYPE,p.CARD_NO,p.MODI_USER,p.MODI_TIME,p.LAST_LOGIN " +
					 " from (select ROW_NUMBER() OVER(ORDER BY t.ID) ROW_NUM," + 
							" t.ID,t.NAME, t.STATUS,t.EXT,t.EMAIL,t.MOBILE,t.CARD_TYPE,t.CARD_NO,t.MODI_USER,t.MODI_TIME,t.LAST_LOGIN " + 
							" from PIS_USER t " +
							" where STATUS = 1 " +
							" and ( ? is null or t.NAME like ?) " +
							" and ( ? is null or t.ID = ?) " +
					 ") p WHERE P.ROW_NUM between ? AND ? ";
			
			List<User> userList = this.jdbcTemplate.query(sql ,new Object[] {name,StringUtil.likeWrap(name),id,id,start,end}, new UserMapper() );
			
			return userList;
		}
		catch(Exception e)
		{
			logger.error(e.toString());
			
			return null;
		}
 
	}


	
}
