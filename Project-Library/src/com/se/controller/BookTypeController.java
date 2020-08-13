package com.se.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.se.bean.BookType;
import com.se.service.IBookTypeService;
import com.se.service.impl.BookTypeServiceImpl;



@Controller
@RequestMapping("/bookTypes")
public class BookTypeController {
	@RequestMapping("/bookTypeList")
	public String bookTypeList(Model model) {
		IBookTypeService bookTypeService=new BookTypeServiceImpl();
			List<BookType> lists =  bookTypeService.findAllBookTypes();
			model.addAttribute("lists", lists);
			return "bookType/bookType-list";
		}
		
	@RequestMapping("/bookTypePWD")
	public String bookTypePWD() {
		return "bookType/bookType-add";
	}
		@RequestMapping("/bookTypeAdd")
		public String bookTypeAdd(BookType bookType,Model model){
			IBookTypeService bookTypeService=new BookTypeServiceImpl();
			bookTypeService.save(bookType);
			List<BookType> lists =  bookTypeService.findAllBookTypes();
			model.addAttribute("lists", lists);
			return "/bookType/bookType-list";
		}
		
		@RequestMapping("/findById")
		public String findById(String id,Model model){
			IBookTypeService bookTypeService=new BookTypeServiceImpl();
			BookType bookType = bookTypeService.findById(id);
			model.addAttribute("bookType", bookType);
			return "/bookType/bookType-edit";
		}
		
		@RequestMapping("/bookTypeUpdate")
		public String bookTypeUpdate(BookType bookType,Model model){
			IBookTypeService bookTypeService=new BookTypeServiceImpl();
			bookTypeService.update(bookType);
			List<BookType> lists =  bookTypeService.findAllBookTypes();
			model.addAttribute("lists", lists);
			return "/bookType/bookType-list";
		}
		
		@RequestMapping("/bookTypeDelete")
		public String bookTypeDelete(String id,Model model){
			IBookTypeService bookTypeService=new BookTypeServiceImpl();
			bookTypeService.delete(id);
			List<BookType> lists =  bookTypeService.findAllBookTypes();
			model.addAttribute("lists", lists);
			return "/bookType/bookType-list";
		}
		
}
