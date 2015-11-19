package com.icbc.pis.taskinwait.service.impl;

public enum OperationEnum {

	checkout(1,"检出"),
	handle(2,"处理");
	
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
