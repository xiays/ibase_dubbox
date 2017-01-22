package com.ibase.server.dao;


import com.ibase.entity.UserInfo;
import com.ibase.server.util.DataSource;
import com.ibase.server.util.DataSourceType;
import com.ibase.server.util.MyMapper;

@DataSource(dbType = DataSourceType.OYJ)
public interface UserDao extends MyMapper<UserInfo> {	
}
