package test;

import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import bean.Order;
import bean.user;
import mapper.ordermapper;

public class mappertest3 {
	/*
	 * 1对1关联
	 */
	@Test
	public void test() throws Exception{
		String resource = "sqlMapConfig.xml";
		InputStream in = Resources.getResourceAsStream(resource);
		//创建sqlsessionfactory
		SqlSessionFactory ssf = new SqlSessionFactoryBuilder().build(in);
		SqlSession session = ssf.openSession();
		ordermapper mapper = session.getMapper(ordermapper.class);
		List<Order> list = mapper.selectorder();
		for (Order order : list) {
			System.out.println(order);
		}
	}
	@Test
	public void test1() throws Exception{
		String resource = "sqlMapConfig.xml";
		InputStream in = Resources.getResourceAsStream(resource);
		//创建sqlsessionfactory
		SqlSessionFactory ssf = new SqlSessionFactoryBuilder().build(in);
		SqlSession session = ssf.openSession();
		ordermapper mapper = session.getMapper(ordermapper.class);
		List<user> list = mapper.selectorders();
		for (user user : list) {
			System.out.println(user);
		}
	}
}
