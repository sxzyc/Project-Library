package com.se.dao.imp;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.se.bean.Reader;
import com.se.dao.IReaderDao;
import com.se.util.MybatisUtils;

public class ReaderDaoImpl implements IReaderDao{
	private static SqlSession session;
	private static String statement;
	
	public List<Reader> getAllReaders() {
		session=MybatisUtils.getFactory();
		statement = "rjxy.userMapper1"+".selectAllReader";
		List<Reader> list=session.selectList(statement);
		return list;
	}

	
	public void save(Reader r) {
		session=MybatisUtils.getFactory();
		statement = "rjxy.userMapper1"+".insertReader";
		session.insert(statement,r);
		session.close();
	}

	
	public Reader getReaderById(String id) {
		session=MybatisUtils.getFactory();
		statement = "rjxy.userMapper1"+".getReader";
		Reader r = session.selectOne(statement,id);
		return r;
	}

	public Reader getReaderBynp(String name,String password) {
		Reader r=new Reader();
		r.setReaderName(name);
		r.setReaderPaw(password);
		session=MybatisUtils.getFactory();
		statement = "rjxy.userMapper1"+".selectReader";
		Reader reader=session.selectOne(statement,r);
		return reader;
	}
	
	public List<Reader> getReaderByUser(String username) {
		
		return null;
	}

	
	public void update(Reader r) {
		session=MybatisUtils.getFactory();
		statement = "rjxy.userMapper1"+".updateReader";
		session.update(statement, r);
		session.close();
	}

	
	public void delete(String id) {
		session=MybatisUtils.getFactory();
		statement = "rjxy.userMapper1"+".deleteReader";
		session.delete(statement,id);
		session.close();
	}

	

}
