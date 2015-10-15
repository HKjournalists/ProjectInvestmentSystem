package com.icbc.pis.workflow.decision;

public enum TransitionTypeEnum {

	NEXT("next",1),CLOSE("close",2),SKIP("skip",3);
	
	private String transName;
	
	private int index;
	
	private TransitionTypeEnum(String transName,int index)
	{
		this.index = index;
		this.transName = transName;
	}
	
	public String toString()
	{
		return this.transName;
	}
	
}
