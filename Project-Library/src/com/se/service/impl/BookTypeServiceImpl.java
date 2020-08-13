package com.se.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.se.bean.BookType;
import com.se.dao.IBookTypeDao;
import com.se.dao.imp.BookTypeDaoImpl;
import com.se.service.IBookTypeService;

public class BookTypeServiceImpl implements IBookTypeService{
	IBookTypeDao booktypedao=new BookTypeDaoImpl();
	
	public List<BookType> findAllBookTypes() {
		List<BookType> list = new ArrayList<BookType>();
		list = booktypedao.getAllBookTypes();
		return list;
	}

	
	public void save(BookType b) {
		booktypedao.save(b);
		
	}

	
	public BookType findById(String id) {
		BookType booktype=booktypedao.getBookTypeById(id);
		return booktype;
	}

	
	public List<BookType> findByBookType(String username) {
		
		return null;
	}

	
	public void update(BookType b) {
		booktypedao.update(b);
	}

	
	public void delete(String id) {
		booktypedao.delete(id);
	}


}
