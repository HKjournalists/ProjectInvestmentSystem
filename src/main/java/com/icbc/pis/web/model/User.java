package com.icbc.pis.web.model;

import java.sql.Timestamp;

public class User implements java.io.Serializable {

	//Private Fields
	private String ID;
	
	private String NAME;

	private String STATUS;
	
	private String EXT;
	
	private String EMAIL;
	
	private String MOBILE;
	
	private String CARD_TYPE;
	
	private String CARD_NO;

	private String MODI_USER;
	
	private String MODI_TIME;
	
	private Timestamp LAST_LOGIN;

	public String getID() {
		return ID;
	}

	public void setID(String iD) {
		ID = iD;
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

	public String getEXT() {
		return EXT;
	}

	public void setEXT(String eXT) {
		EXT = eXT;
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

	public String getMODI_TIME() {
		return MODI_TIME;
	}

	public void setMODI_TIME(String mODI_TIME) {
		MODI_TIME = mODI_TIME;
	}

	public Timestamp getLAST_LOGIN() {
		return LAST_LOGIN;
	}

	public void setLAST_LOGIN(Timestamp lAST_LOGIN) {
		LAST_LOGIN = lAST_LOGIN;
	}

	public User(String iD, String nAME, String sTATUS, String eXT, String eMAIL, String mOBILE, String cARD_TYPE,
			String cARD_NO, String mODI_USER, String mODI_TIME, Timestamp lAST_LOGIN) {
		super();
		ID = iD;
		NAME = nAME;
		STATUS = sTATUS;
		EXT = eXT;
		EMAIL = eMAIL;
		MOBILE = mOBILE;
		CARD_TYPE = cARD_TYPE;
		CARD_NO = cARD_NO;
		MODI_USER = mODI_USER;
		MODI_TIME = mODI_TIME;
		LAST_LOGIN = lAST_LOGIN;
	}

	
	
	
}
