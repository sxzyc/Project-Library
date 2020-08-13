package com.se.service;

import java.util.List;

import com.se.bean.Reader;


public interface IReaderService {
	List<Reader> findAllReaders();
	void save(Reader r); 
	
	Reader findById(String id);
	List<Reader> findByReader(String username);
	Reader getReaderBynp(String name,String password);
	void update(Reader r);
	
	void delete(String id);
}
