package daoimpl;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import bean.user;
import dao.dao;

public class daoimpl implements dao {
	private SqlSessionFactory ssf;

	public daoimpl(SqlSessionFactory ssf) {
		this.ssf = ssf;
	}
	public user selectbyid(int id){
		SqlSession ss = ssf.openSession();
		return ss.selectOne("test.findbyuserid", id);
	}
	
}
