package com.se.dao.imp;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.se.bean.Book;
import com.se.dao.IBookDao;
import com.se.util.MybatisUtils;

public class BookDaoImpl implements IBookDao{
	private static SqlSession session;
	private static String statement;
	
	public List<Book> getAllBooks() {
		session=MybatisUtils.getFactory();
		statement = "rjxy.userMapper1"+".selectAllBook";
		List<Book> list=session.selectList(statement);
		return list;
	}

	
	public void save(Book b) {
		session=MybatisUtils.getFactory();
		statement = "rjxy.userMapper1"+".insertBook";
		session.insert(statement,b);
		session.close();
	}

	
	public Book getBookById(String id) {
		session=MybatisUtils.getFactory();
		statement = "rjxy.userMapper1"+".getBook";
		Book b = session.selectOne(statement,id);
		return b;
	}

	
	public List<Book> getBookByUser(String username) {
		
		return null;
	}

	
	public void update(Book b) {
		session=MybatisUtils.getFactory();
		statement = "rjxy.userMapper1"+".updateBook";
		session.update(statement, b);
		session.close();
	}

	
	public void delete(String id) {
		session=MybatisUtils.getFactory();
		statement = "rjxy.userMapper1"+".deleteBook";
		session.delete(statement,id);
		session.close();
	}

	

}
