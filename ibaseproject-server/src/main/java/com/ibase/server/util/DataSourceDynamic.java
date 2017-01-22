package com.ibase.server.util;

import org.apache.log4j.Logger;
import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

public class DataSourceDynamic extends AbstractRoutingDataSource
{
	static Logger log = Logger.getLogger("DynamicDataSource");   
	private final static ThreadLocal<String> dataSourceKey = new InheritableThreadLocal<String>();

    public static void setDataSourceKey(String dataSource){
        dataSourceKey.set(dataSource);
    }
    
	@Override 
	protected Object determineCurrentLookupKey()
	{
		//TODO Auto-generated method stub   
		return DataSourceHolder.getDbType();  
	}
	
	public java.util.logging.Logger getParentLogger()
	{
		// TODO Auto-generated method stub
		return null;
	} 
}  

