package test;

import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import bean.user;

public class mybatistest {
	@Test
	public void test() throws Exception{
		//加载核心资源
		String resource = "sqlMapConfig.xml";
		InputStream in = Resources.getResourceAsStream(resource);
		//创建sqlsessionfactory
		SqlSessionFactory ssf = new SqlSessionFactoryBuilder().build(in);
		SqlSession ss = ssf.openSession();		
		//执行sql语句
		//user u = ss.selectOne("test.findbyuserid", 1);
		List<user> us = ss.selectList("findbyuser","肖");
		for(user u : us){		
			System.out.println(u);
		}
	}
	@Test
	public void test1() throws Exception{
		//加载核心资源
		String resource = "sqlMapConfig.xml";
		InputStream in = Resources.getResourceAsStream(resource);
		//创建sqlsessionfactory
		SqlSessionFactory ssf = new SqlSessionFactoryBuilder().build(in);
		SqlSession ss = ssf.openSession();		
		//执行sql语句
		user u = new user();
		u.setName("sb100000");
		u.setMoney("100086");
		ss.insert("test.insert", u);
		//ss.commit();
		System.out.println(u.getId());
	}
	@Test
	public void test2() throws Exception{
		//加载核心资源
		String resource = "sqlMapConfig.xml";
		InputStream in = Resources.getResourceAsStream(resource);
		//创建sqlsessionfactory
		SqlSessionFactory ssf = new SqlSessionFactoryBuilder().build(in);
		SqlSession ss = ssf.openSession();		
		//执行sql语句
		user u = new user();
		u.setId(8);
		u.setName("hello");
		u.setMoney("100086");
		ss.update("test.updateuser", u);
		ss.delete("test.deletebyid", 8);
		ss.commit();
		
	}
	
}
