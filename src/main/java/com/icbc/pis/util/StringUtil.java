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
	
	public static String getSplitStrByIndex(String resourceStr,int index) {
		
		String seprator = "\\.";
		
		return getSplitStrByIndex(resourceStr,index,seprator);
		
	}
	//指定字符串按照变量分割后获取自核定索引位置的字符串
	public static String getSplitStrByIndex(String resourceStr,int index, String seprator) {
		
		if(StringUtil.isNullOrEmpty(resourceStr)){
			
			return "";
		}
		
		String[] strs = resourceStr.split(seprator);
		
		String returnStr = "";
		
		if(strs != null && strs.length > index){
			
			returnStr = strs[index];
			
		}
		
		return returnStr;
	}
}
