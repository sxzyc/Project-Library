package com.se.dao.imp;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.se.bean.BookType;
import com.se.dao.IBookTypeDao;
import com.se.util.MybatisUtils;

public class BookTypeDaoImpl implements IBookTypeDao{
	private static SqlSession session;
	private static String statement;
	
	public List<BookType> getAllBookTypes() {
		session=MybatisUtils.getFactory();
		statement = "rjxy.userMapper1"+".selectAllBookType";
		List<BookType> list=session.selectList(statement);
		return list;
	}

	
	public void save(BookType b) {
		session=MybatisUtils.getFactory();
		statement = "rjxy.userMapper1"+".insertBookType";
		session.insert(statement,b);
		session.close();
	}

	
	public BookType getBookTypeById(String id) {
		session=MybatisUtils.getFactory();
		statement = "rjxy.userMapper1"+".getBookType";
		BookType b = session.selectOne(statement,id);
		return b;
	}

	
	public List<BookType> getBookTypeByUser(String username) {
		
		return null;
	}

	
	public void update(BookType b) {
		session=MybatisUtils.getFactory();
		statement = "rjxy.userMapper1"+".updateBookType";
		session.update(statement, b);
		session.close();
	}

	
	public void delete(String id) {
		session=MybatisUtils.getFactory();
		statement = "rjxy.userMapper1"+".deleteBookType";
		session.delete(statement,id);
		session.close();
	}

	

}
