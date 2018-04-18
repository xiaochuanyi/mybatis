package test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import bean.user;
import mapper.UserMapper;

public class SpringAndMybatis {
	@Test
	public void test1(){
		ApplicationContext ac = new ClassPathXmlApplicationContext("/config/applicationContext.xml");
		UserMapper us = (UserMapper)ac.getBean("userMapper");
		user u = us.select(1);
		System.out.println(u);
	}
	
}
