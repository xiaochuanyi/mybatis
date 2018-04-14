package test;

import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import bean.user;

public class mybatistest {
	@Test
	public void test() throws Exception{
		//���غ�����Դ
		String resource = "sqlMapConfig.xml";
		InputStream in = Resources.getResourceAsStream(resource);
		//����sqlsessionfactory
		SqlSessionFactory ssf = new SqlSessionFactoryBuilder().build(in);
		SqlSession ss = ssf.openSession();		
		//ִ��sql���
		user u = ss.selectOne("test.findbyuserid", 1);
		System.out.println(u);
	}
}
