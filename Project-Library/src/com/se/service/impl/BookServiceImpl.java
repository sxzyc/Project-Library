package com.se.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.se.bean.Book;
import com.se.dao.IBookDao;
import com.se.dao.imp.BookDaoImpl;
import com.se.service.IBookService;

public class BookServiceImpl implements IBookService{
	IBookDao bookdao=new BookDaoImpl();
	
	public List<Book> findAllBooks() {
		List<Book> list = new ArrayList<Book>();
		list = bookdao.getAllBooks();
		return list;
	}

	
	public void save(Book b) {
		bookdao.save(b);
		
	}

	
	public Book findById(String id) {
		Book book=bookdao.getBookById(id);
		return book;
	}

	
	public List<Book> findByBook(String username) {
		
		return null;
	}

	
	public void update(Book b) {
		bookdao.update(b);
	}

	
	public void delete(String id) {
		bookdao.delete(id);
	}


}
