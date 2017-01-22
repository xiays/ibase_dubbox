package com.ibase.server.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ibase.api.IUser;
import com.ibase.entity.UserInfo;
import com.ibase.server.dao.UserDao;
import com.ibase.server.util.DataSource;
import com.ibase.server.util.DataSourceHolder;
import com.ibase.server.util.DataSourceType;

import tk.mybatis.mapper.entity.Example;

/**
 * @author admin
 *
 */
@Service
public class UserImpl implements IUser{ 
	
	@Autowired	
	private UserDao mapper;
	
	@Override		
	public UserInfo selectbyid(Integer id)
	{
		//DataSourceHolder.setDbType(DataSourceType.OYJ);		 
		return mapper.selectByPrimaryKey(id);
		
//		UserInfo info=new UserInfo();
//		info.setId(id);
//		info.setUsername("test");
//		return info;
	}
	@Override
	public int update(UserInfo record)
	{
		return 0;
	}
	
	@Override	
	public PageInfo<UserInfo> selectBypage(UserInfo t, int page, int rows) 
	{
		//DataSourceHolder.setDbType(DataSourceType.OYJ);		 
		Example example = new Example(UserInfo.class);
		//
		//mapper.selectByExample(example)
		// 分页查询
		PageHelper.startPage(page, rows,"id");
		//List<UserInfo> u= mapper.selectByExample(example);
		//System.out.println(mapper.selectByExample(example));
		List<UserInfo> p=mapper.select(t);		
		PageInfo<UserInfo> pageInfo = new PageInfo<UserInfo>(p);
		//PageInfo<UserInfo> pageInfo = new PageInfo<UserInfo>(p);
	    //System.out.println(pageInfo.getList());
	    //System.out.println(pageInfo.getPageSize());
	    //System.out.println(pageInfo.getResult().size());
	    //System.out.println(pageInfo.getResult().get(1));
	     return pageInfo;
	}
}
