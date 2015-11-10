package com.icbc.pis.util;

public class StringUtil {

	public static boolean isNullOrEmpty(String str)
	{
		if(str == null || str.length() == 0)
		{
			return true;
		}
		
		return false;
		
	}
	
	public static String getFirst(String[] strArray)
	{
		if(strArray == null || strArray.length == 0)
		{
			return null;
		}
		
		return strArray[0];
	}
	
	public static String likeWrap(String str)
	{
		if(StringUtil.isNullOrEmpty(str))
		{
			return "%%";
		}
		
		String like = "%";
		
		return like + str + like;
	}
}
