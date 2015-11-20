package com.icbc.pis.util;

public class DoubleUtil {

	public static double parseDouble(String str)
	{
		if(StringUtil.isNullOrEmpty(str))
		{
			return 0;
		}
		
		return Double.parseDouble(str);
		
	}
}
