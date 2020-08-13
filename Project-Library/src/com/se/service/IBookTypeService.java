package com.se.service;

import java.util.List;

import com.se.bean.BookType;



public interface IBookTypeService {
	List<BookType> findAllBookTypes();
	void save(BookType b); 
	
	BookType findById(String id);
	List<BookType> findByBookType(String username);
	
	void update(BookType b);
	
	void delete(String id);
}
