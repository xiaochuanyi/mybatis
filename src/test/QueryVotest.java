package test;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import bean.QueryVo;
import bean.user;
import mapper.mapperdao;

public class QueryVotest {
	@Test
	public void test() throws Exception{
		String resource = "sqlMapConfig.xml";
		InputStream in = Resources.getResourceAsStream(resource);
		//创建sqlsessionfactory
		SqlSessionFactory ssf = new SqlSessionFactoryBuilder().build(in);
		SqlSession session = ssf.openSession();
		mapperdao mapper = session.getMapper(mapperdao.class);
		QueryVo vo = new QueryVo();
		user u = new user();
		u.setName("肖");
		vo.setU(u);
		System.out.println(vo.getU().getName());
		List<user> ls = mapper.findbyQueryVo(vo);
		for(user a : ls){
			System.out.println(a);
		}
	}
	@Test
	public void test1() throws Exception{
		String resource = "sqlMapConfig.xml";
		InputStream in = Resources.getResourceAsStream(resource);
		//创建sqlsessionfactory
		SqlSessionFactory ssf = new SqlSessionFactoryBuilder().build(in);
		SqlSession session = ssf.openSession();
		mapperdao mapper = session.getMapper(mapperdao.class);
		user u = new user();
		u.setMoney(null);
		u.setName("小红");
		List<user> l = mapper.findbynameandmoney(u);
		for(user s : l){
			System.out.println(s);
		}
	}
	@Test
	public void test2() throws Exception{
		String resource = "sqlMapConfig.xml";
		InputStream in = Resources.getResourceAsStream(resource);
		//创建sqlsessionfactory
		SqlSessionFactory ssf = new SqlSessionFactoryBuilder().build(in);
		SqlSession session = ssf.openSession();
		mapperdao mapper = session.getMapper(mapperdao.class);
		user u = new user();
		List<Integer> ls = new ArrayList<Integer>();
		ls.add(1);
		ls.add(2);
		QueryVo vo =new QueryVo();
		vo.setList(ls);
		List<user> list = mapper.findbyids(vo);
		for(user us : list){
			System.out.println(us);
		}
	}
}
