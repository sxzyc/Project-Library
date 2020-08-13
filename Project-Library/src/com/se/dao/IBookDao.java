package com.se.dao;

import java.util.List;

import com.se.bean.Book;


public interface IBookDao {
	List<Book> getAllBooks();
	void save(Book b); 
	Book getBookById(String id);
	List<Book> getBookByUser(String username);
	void update(Book b);
	void delete(String id);
}
