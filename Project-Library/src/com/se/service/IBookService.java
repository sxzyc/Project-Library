package com.se.service;

import java.util.List;

import com.se.bean.Book;


public interface IBookService {
	List<Book> findAllBooks();
	void save(Book b); 
	
	Book findById(String id);
	List<Book> findByBook(String username);
	
	void update(Book b);
	
	void delete(String id);
}
