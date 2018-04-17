package test;

import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import bean.user;
import mapper.mapperdao;

public class mappertest {
	@Test
	public void test1() throws Exception{
		String resource = "sqlMapConfig.xml";
		InputStream in = Resources.getResourceAsStream(resource);
		//´´½¨sqlsessionfactory
		SqlSessionFactory ssf = new SqlSessionFactoryBuilder().build(in);
		SqlSession session = ssf.openSession();
		mapperdao mapper = session.getMapper(mapperdao.class);
		user us = mapper.findbyuserid(5);
		System.out.println(us);
	}
}
