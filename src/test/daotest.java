package test;

import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import bean.user;
import dao.dao;
import daoimpl.daoimpl;

public class daotest {
	public SqlSessionFactory ssf;
	@org.junit.Before//ʹ��beforeע�����˷����ڲ��Ե�Ԫ֮ǰ����
	public void Before() throws Exception{
		String resource = "sqlMapConfig.xml";
		InputStream in = Resources.getResourceAsStream(resource);
		//����sqlsessionfactory
		ssf = new SqlSessionFactoryBuilder().build(in);
	}
	@Test
	public void test(){
		dao dl = new daoimpl(ssf);
		user u = dl.selectbyid(1);
		System.out.println(u);
	}
}
