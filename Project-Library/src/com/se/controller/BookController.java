package com.se.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.se.bean.Book;
import com.se.service.IBookService;
import com.se.service.impl.BookServiceImpl;



@Controller
@RequestMapping("/books")
public class BookController {
	@RequestMapping("/bookList")
	protected String bookList(Model model) {
		IBookService bookService=new BookServiceImpl();
			List<Book> lists =  bookService.findAllBooks();
			model.addAttribute("lists", lists);
			return "books/books-list";
		}
		
	@RequestMapping("/bookPWD")
	protected String bookPWD() {
		return "books/books-add";
	}
		@RequestMapping("/bookAdd")
		public String bookAdd(Book book,Model model){
			IBookService bookService=new BookServiceImpl();
			bookService.save(book);
			List<Book> lists =  bookService.findAllBooks();
			model.addAttribute("lists", lists);
			return "/books/books-list";
		}
		
		@RequestMapping("/findById")
		public String findById(String id,Model model){
			IBookService bookService=new BookServiceImpl();
			Book books = bookService.findById(id);
			model.addAttribute("books", books);
			return "/books/books-edit";
		}
		
		@RequestMapping("/bookUpdate")
		public String bookUpdate(Book book,Model model){
			IBookService bookService=new BookServiceImpl();
			bookService.update(book);
			List<Book> lists =  bookService.findAllBooks();
			model.addAttribute("lists", lists);
			return "/books/books-list";
		}
		
		@RequestMapping("/bookDelete")
		public String bookDelete(String id,Model model){
			IBookService bookService=new BookServiceImpl();
			bookService.delete(id);
			List<Book> lists =  bookService.findAllBooks();
			model.addAttribute("lists", lists);
			return "/books/books-list";
		}
		
}
