package com.se.dao;

import java.util.List;

import com.se.bean.BookType;



public interface IBookTypeDao {
	List<BookType> getAllBookTypes();
	void save(BookType b); 
	BookType getBookTypeById(String id);
	List<BookType> getBookTypeByUser(String username);
	void update(BookType b);
	void delete(String id);
}
