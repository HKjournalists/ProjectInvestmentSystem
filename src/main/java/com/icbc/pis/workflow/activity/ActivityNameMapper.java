package com.icbc.pis.workflow.activity;

public class ActivityNameMapper {

	public static String ActivityNameEng2Chi(String engName)
	{
		for (ActivityNameEnum c : ActivityNameEnum.values()) 
		{
			if (engName.equals(c.getEngName())) 
			{
				return c.getChiName();
			}
		}
		
		return "项目结束";
		
	}
}
