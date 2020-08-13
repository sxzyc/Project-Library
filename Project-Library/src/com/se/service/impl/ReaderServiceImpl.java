package com.se.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.se.bean.Reader;
import com.se.dao.IReaderDao;
import com.se.dao.imp.ReaderDaoImpl;
import com.se.service.IReaderService;

public class ReaderServiceImpl implements IReaderService{
	IReaderDao readerdao=new ReaderDaoImpl();
	
	public List<Reader> findAllReaders() {
		List<Reader> list = new ArrayList<Reader>();
		list = readerdao.getAllReaders();
		return list;
	}

	
	public void save(Reader r) {
		readerdao.save(r);
		
	}

	
	public Reader findById(String id) {
		Reader reader=readerdao.getReaderById(id);
		return reader;
	}

	public Reader getReaderBynp(String name,String password) {
		Reader reader=readerdao.getReaderBynp(name, password);
		return reader;
	}
	
	public List<Reader> findByReader(String username) {
		
		return null;
	}

	
	public void update(Reader r) {
		readerdao.update(r);
	}

	
	public void delete(String id) {
		readerdao.delete(id);
	}

}
