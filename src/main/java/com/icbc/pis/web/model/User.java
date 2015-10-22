package com.icbc.pis.web.model;

import java.sql.Timestamp;

public class User implements java.io.Serializable {

	//Private Fields
	private String id;
	
	private String name;

	private String status;
	
	private String ext;
	
	private String email;
	
	private String mobile;
	
	private String cardType;
	
	private String cardNo;

	private String modiUser;
	
	private Timestamp modiTime;
	
	private Timestamp lastLogin;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getExt() {
		return ext;
	}

	public void setExt(String ext) {
		this.ext = ext;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getCardType() {
		return cardType;
	}

	public void setCardType(String cardType) {
		this.cardType = cardType;
	}

	public String getCardNo() {
		return cardNo;
	}

	public void setCardNo(String cardNo) {
		this.cardNo = cardNo;
	}

	public String getModiUser() {
		return modiUser;
	}

	public void setModiUser(String modiUser) {
		this.modiUser = modiUser;
	}

	public Timestamp getModiTime() {
		return modiTime;
	}

	public void setModiTime(Timestamp modiTime) {
		this.modiTime = modiTime;
	}

	public Timestamp getLastLogin() {
		return lastLogin;
	}

	public void setLastLogin(Timestamp lastLogin) {
		this.lastLogin = lastLogin;
	}

	public User(String id, String name, String status, String ext, String email, String mobile, String cardType,
			String cardNo, String modiUser, Timestamp modiTime, Timestamp lastLogin) {
		
		super();
		
		this.id = id;
		
		this.name = name;
		
		this.status = status;
		
		this.ext = ext;
		
		this.email = email;
		
		this.mobile = mobile;
		
		this.cardType = cardType;
		
		this.mobile = mobile;
		
		this.cardNo = cardNo;
		
		this.modiUser = modiUser;
		
		this.modiTime = modiTime;
		
		this.lastLogin = lastLogin;
	}

	
	
	
}
