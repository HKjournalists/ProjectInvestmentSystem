package com.icbc.pis.datastruct;

import java.util.List;

import com.icbc.pis.web.model.*;

public class UserInfo {

	private User userBasicInfo;
	
	private List<UserRole> roleList;
	
	public UserInfo(User userBasicInfo,List<UserRole> roleList)
	{
		this.userBasicInfo = userBasicInfo;
		
		this.roleList = roleList;
	}

	public User getUserBasicInfo() {
		return userBasicInfo;
	}

	public void setUserBasicInfo(User userBasicInfo) {
		this.userBasicInfo = userBasicInfo;
	}

	public List<UserRole> getRoleList() {
		return roleList;
	}

	public void setRoleList(List<UserRole> roleList) {
		this.roleList = roleList;
	}
}
