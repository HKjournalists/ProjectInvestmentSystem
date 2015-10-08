package com.icbc.pis.web.model;

import java.sql.Timestamp;

public class User implements java.io.Serializable {

	//Private Fields
	private String ID;
	
	private String BRANCH_ID;
	
	private String NAME;

	private String STATUS;
	
	private String PHONE_NO;
	
	private String EMAIL;
	
	private String MOBILE;
	
	private String INTERIOR_FLAG;
	
	private String CARD_TYPE;

	private String CARD_NO;
	
	private String MODI_USER;
	
	private Timestamp createTime;
	
	public User(String iD, String bRANCH_ID, String nAME, String sTATUS, String pHONE_NO, String eMAIL, String mOBILE,
			String iNTERIOR_FLAG, String cARD_TYPE, String cARD_NO, String mODI_USER, Timestamp createTime,
			Timestamp lAST_LOGIN, String wHITE_LIST) {
		super();
		ID = iD;
		BRANCH_ID = bRANCH_ID;
		NAME = nAME;
		STATUS = sTATUS;
		PHONE_NO = pHONE_NO;
		EMAIL = eMAIL;
		MOBILE = mOBILE;
		INTERIOR_FLAG = iNTERIOR_FLAG;
		CARD_TYPE = cARD_TYPE;
		CARD_NO = cARD_NO;
		MODI_USER = mODI_USER;
		this.createTime = createTime;
		LAST_LOGIN = lAST_LOGIN;
		WHITE_LIST = wHITE_LIST;
	}
	public String getID() {
		return ID;
	}
	public void setID(String iD) {
		ID = iD;
	}
	public String getBRANCH_ID() {
		return BRANCH_ID;
	}
	public void setBRANCH_ID(String bRANCH_ID) {
		BRANCH_ID = bRANCH_ID;
	}
	public String getNAME() {
		return NAME;
	}
	public void setNAME(String nAME) {
		NAME = nAME;
	}
	public String getSTATUS() {
		return STATUS;
	}
	public void setSTATUS(String sTATUS) {
		STATUS = sTATUS;
	}
	public String getPHONE_NO() {
		return PHONE_NO;
	}
	public void setPHONE_NO(String pHONE_NO) {
		PHONE_NO = pHONE_NO;
	}
	public String getEMAIL() {
		return EMAIL;
	}
	public void setEMAIL(String eMAIL) {
		EMAIL = eMAIL;
	}
	public String getMOBILE() {
		return MOBILE;
	}
	public void setMOBILE(String mOBILE) {
		MOBILE = mOBILE;
	}
	public String getINTERIOR_FLAG() {
		return INTERIOR_FLAG;
	}
	public void setINTERIOR_FLAG(String iNTERIOR_FLAG) {
		INTERIOR_FLAG = iNTERIOR_FLAG;
	}
	public String getCARD_TYPE() {
		return CARD_TYPE;
	}
	public void setCARD_TYPE(String cARD_TYPE) {
		CARD_TYPE = cARD_TYPE;
	}
	public String getCARD_NO() {
		return CARD_NO;
	}
	public void setCARD_NO(String cARD_NO) {
		CARD_NO = cARD_NO;
	}
	public String getMODI_USER() {
		return MODI_USER;
	}
	public void setMODI_USER(String mODI_USER) {
		MODI_USER = mODI_USER;
	}
	public Timestamp getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Timestamp createTime) {
		this.createTime = createTime;
	}
	public Timestamp getLAST_LOGIN() {
		return LAST_LOGIN;
	}
	public void setLAST_LOGIN(Timestamp lAST_LOGIN) {
		LAST_LOGIN = lAST_LOGIN;
	}
	public String getWHITE_LIST() {
		return WHITE_LIST;
	}
	public void setWHITE_LIST(String wHITE_LIST) {
		WHITE_LIST = wHITE_LIST;
	}
	private Timestamp LAST_LOGIN;
	private String WHITE_LIST;
	
	
}
