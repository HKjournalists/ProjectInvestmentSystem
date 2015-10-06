package com.icbc.pis.web.model;

import java.sql.Timestamp;

public class User implements java.io.Serializable {

	//Private Fields
	private String userId;
	
	private String userName;
	
	private String pswd;

	private String email;
	
	private String ext;

	private Timestamp createTime;

	private String mobile;
	
	public User(String userId,String userName,String email,String mobile,String ext,Timestamp createTime)
	{
		this.userId = userId;
		
		this.userName = userName;
		
		this.email = email;
		
		this.ext = ext;
		
		this.mobile = mobile;
		
		this.createTime = createTime;

	}
	
	public User(String userId,String userName,String pswd,String email,String mobile,String ext,Timestamp createTime)
	{
		this.userId = userId;
		
		this.userName = userName;
		
		this.pswd = pswd;
		
		this.email = email;
		
		this.ext = ext;
		
		this.mobile = mobile;
		
		this.createTime = createTime;

	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getExt() {
		return ext;
	}

	public void setExt(String ext) {
		this.ext = ext;
	}

	public Timestamp getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Timestamp createTime) {
		this.createTime = createTime;
	}
	
	
	public String getPswd() {
		return pswd;
	}

	public void setPswd(String pswd) {
		this.pswd = pswd;
	}
}
