package com.icbc.pis.user.dao.impl;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
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

	private static final Logger logger = LoggerFactory.getLogger(UserService.class);
	@Autowired
	private JdbcTemplate jdbcTemplate;
	@Override
	public User getUserByUserId(String userId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<User> getAllUserList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User getUserById(String userId) {
		String sql = "select * from pis_user where id=?";
		User user=jdbcTemplate.queryForObject(sql, new Object[] { userId },
		new UserMapper());
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
		String sql = "select * from accounter_career";
		return false;
	}

	@Override
	public int count(){
		
		return 5;
	}
	
	@Override
	public List<User> getUsersByCondition(Map<String, String[]> filterMap) {
		// TODO Auto-generated method stub
		
		String start = StringUtil.getFirst(filterMap.get("start"));
		
		String number = StringUtil.getFirst(filterMap.get("number"));
		
		int iStart = 1;
		
		int iNum = 10;
		
		if(StringUtil.isNullOrEmpty(start) || StringUtil.isNullOrEmpty(number))
		{
			return null;
		}
		else
		{
			iStart = Integer.parseInt(start);
			
			iNum = Integer.parseInt(number);
		}
		
		List<User> userlist = new ArrayList<User>();
		
		String names[] = {"yuezhi liu","jennifer","柳栋名","刘悦之","操蛋","麦当劳","开封菜","sara","lala","苍井空"};
		String ext[] = {"1231","1234","4343","3452","1111","454","5652","1231","123123","3242"};
		String mobile[] = {"1801811111","1801812323","137980802323","13433434323","134231512313","13856565565","139234234234","234234234","23423423","123123123"};
		
		for(int i = 0 ; i < iNum; i++)
		{
			int randomIndex = (int) (Math.random() * 10);
			
			int id = iStart + i;
			
			//User u = new User(((Integer)id).toString(), names[randomIndex], names[randomIndex] + "@icbc.com", mobile[randomIndex], ext[randomIndex], new Timestamp(System.currentTimeMillis()));
		
			//userlist.add(u);
		}
		
		return userlist;
	}


	
}
