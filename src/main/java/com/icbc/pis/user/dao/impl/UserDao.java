package com.icbc.pis.user.dao.impl;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapperResultSetExtractor;
import org.springframework.stereotype.Repository;

import com.icbc.pis.common.dao.ICommonOperDao;
import com.icbc.pis.user.dao.IUserDao;
import com.icbc.pis.user.service.impl.UserService;
import com.icbc.pis.web.mapper.UserMapper;
import com.icbc.pis.web.model.User;
import com.icbc.pis.web.model.UserRole;
import com.icbc.pis.web.utils.StringUtil;
@Repository("UserDao")
public class UserDao implements IUserDao,ICommonOperDao{

	private static final Logger logger = LoggerFactory.getLogger(UserDao.class);
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public List<User> getAllUserList() {
		// TODO Auto-generated method stub
		
		String sql = "select * from pis_user";
		
		List<User> userList = (List<User>) jdbcTemplate.queryForObject(sql, new Object[] {}, new UserMapper());
		
		return userList;
	}

	@Override
	public User getUserById(String userId) {
		logger.debug("begin getUserById");
		
		String sql = "select * from pis_user where id=?";
		
		User user = jdbcTemplate.queryForObject(sql, new Object[] { userId }, new UserMapper());
		
		logger.debug("end getUserById");
		return user;
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
	public boolean add(Object obj) {
		// TODO Auto-generated method stub
		User user = (User) obj;
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
		//String sql = "select * from accounter_career";
		return false;
	}

	@Override
	public int count(){
		
		int cnt = jdbcTemplate.queryForObject("select count(*) from PIS_USER", Integer.class);
		return cnt;
	}
	
	@Override
	public List<User> getUsersByCondition(Map<String, String[]> filterMap) {
		// TODO Auto-generated method stub
		
 		String start = StringUtil.getFirst(filterMap.get("start"));
		
		String number = StringUtil.getFirst(filterMap.get("number"));
		
		Integer iEnd = Integer.parseInt(start) + Integer.parseInt(number) - 1;
		
		String end = iEnd.toString();
		
		String name = StringUtil.getFirst(filterMap.get("name")) ;
		
		String id = StringUtil.getFirst(filterMap.get("id"));
		
//		int iStart = 1;
//		
//		int iNum = 10;
		
//		if(StringUtil.isNullOrEmpty(start) || StringUtil.isNullOrEmpty(number))
//		{
//			return null;
//		}
//		else
//		{
//			iStart = Integer.parseInt(start);
//			
//			iNum = Integer.parseInt(number);
//		}
		
//		String sql = " select p.id,p.name,p.status,p.ext,p.email,p.mobile,p.card_type,p.card_no,p.modi_user,p.modi_time,p.last_login " +
//					 " from (select ROW_NUMBER() OVER(ORDER BY t.id) ROW_NUM," + 
//							" t.id,t.name, t.status,t.ext,t.email,t.mobile,t.card_type,t.card_no,t.modi_user,t.modi_time,t.last_login " + 
//							" from pis_user t " +
//							" where (? is null or t.name like ? ) " +
//							" and ( ? is null or t.id = ? ) " +
//					 ") p WHERE P.ROW_NUM between ? AND ? ";
		
		
		try
		{
			//String nameCond = StringUtil.isNullOrEmpty(name) ? " ":" t.NAME like ?  ";
			//String idCond = StringUtil.isNullOrEmpty(id) ? " ":" and  t.ID = ?  ";
			String sql = " select p.ID,p.NAME,p.STATUS,p.EXT,p.EMAIL,p.MOBILE,p.CARD_TYPE,p.CARD_NO,p.MODI_USER,p.MODI_TIME,p.LAST_LOGIN " +
					 " from (select ROW_NUMBER() OVER(ORDER BY t.ID) ROW_NUM," + 
							" t.ID,t.NAME, t.STATUS,t.EXT,t.EMAIL,t.MOBILE,t.CARD_TYPE,t.CARD_NO,t.MODI_USER,t.MODI_TIME,t.LAST_LOGIN " + 
							" from PIS_USER t " +
							" where 1 = 1" +
							" and ( ? is null or t.NAME like ?) " +
							" and ( ? is null or t.ID = ?) " +
					 ") p WHERE P.ROW_NUM between ? AND ? ";
			//(List<User>) jdbcTemplate.queryForObject(sql, new Object[] {name,id,start,end}, new UserMapper());
			List<User> userList = jdbcTemplate.query(sql ,new Object[] {name,StringUtil.likeWrap(name),id,id,start,end}, new UserMapper() );
			
			return userList;
		}
		catch(Exception e)
		{
			return null;
		}
 
	}


	
}
