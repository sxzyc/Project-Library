package com.se.dao;

import java.util.List;

import com.se.bean.Reader;



public interface IReaderDao {
	List<Reader> getAllReaders();
	void save(Reader b); 
	Reader getReaderById(String id);
	List<Reader> getReaderByUser(String username);
	Reader getReaderBynp(String name,String password);
	void update(Reader r);
	void delete(String id);
}
