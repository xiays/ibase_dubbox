package org.ibaseproject.server;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.ibase.entity.UserInfo;
import com.ibase.server.dao.UserDao;
import com.ibase.server.impl.UserImpl;


/**
 * Unit test for simple App.
 */
@RunWith(SpringJUnit4ClassRunner.class) 
@ContextConfiguration(locations={"classpath:spring-registry.xml","classpath:spring-mybatis.xml"})  
public class AppTest  
{
     
    @Autowired
    private UserDao muserService;   
   
    @Test  
    public void testApp()
    {
    	UserInfo info = muserService.selectByPrimaryKey(5);
    	//UserInfo info = l.selectbyid(5);
        System.out.println(info.getUsername());
    	System.out.println("AA");
        
    }
}
