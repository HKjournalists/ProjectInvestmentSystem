package com.icbc.pis.taskinwait.service.impl;

public enum OperationEnum {

	handle(1,"处理"),
	checkout(2,"检出");
	
	
	private int index;
	
	private String operation;
	
	private OperationEnum(int index,String operation)
	{
		this.index = index;
		this.operation = operation;
	}
	
	public int getIndex()
	{
		return this.index;
	}
	
	public String getOperation()
	{
		return this.operation;
	}
	
}
