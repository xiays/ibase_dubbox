package com.ibase.server.util;

public class DataSourceHolder {  
	
	private static final ThreadLocal contextHolder = new ThreadLocal();  
	
	public static void setDbType(DataSourceType dbType)
	{    
		setDbType(dbType.toString(),true);
	}   
	
	public static void setDbType(String dbType,Boolean isString)
	{    
		contextHolder.set(dbType.toString());  
	}   
	
	public static String getDbType() 
	{   
		return (String) contextHolder.get();  
	}   
	
	public static void clearDbType() 
	{   
		contextHolder.remove();  
	}
}  

