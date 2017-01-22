package com.ibase.api;

import com.github.pagehelper.PageInfo;
import com.ibase.entity.UserInfo;

public interface IUser {
	UserInfo selectbyid(Integer id);
	int update(UserInfo record);
	PageInfo<UserInfo> selectBypage(UserInfo t, int page, int rows) ;
	
}
