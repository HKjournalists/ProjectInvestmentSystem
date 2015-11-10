package com.icbc.pis.web.model;

public class DictItem {
	
	private String key;
	
	private String value;

	public String getKey() {
		return this.key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}
	
	public DictItem(String key,String value)
	{
		this.key = key;
		
		this.value = value;
	}
}
