package com.se.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.se.bean.Reader;
import com.se.service.IReaderService;
import com.se.service.impl.ReaderServiceImpl;
import com.se.util.MD5Util;



@Controller
@RequestMapping("/reader")
public class ReaderController {
	@RequestMapping("/readerList")
	protected String readerList(Model model) {
			IReaderService readerService=new ReaderServiceImpl();
			List<Reader> readers =  readerService.findAllReaders();
			model.addAttribute("readers", readers);
			return "readers/readers-list";
		}
		
	@RequestMapping("/readerPWD")
	protected String readerPWD() {
		return "readers/readers-add";
	}
		@RequestMapping("/readerAdd")
		public String readerAdd(Reader reader,Model model){
			IReaderService readerService=new ReaderServiceImpl();
			reader.setReaderPaw(MD5Util.encode(reader.getReaderPaw()));
			readerService.save(reader);
			List<Reader> readers =  readerService.findAllReaders();
			model.addAttribute("readers", readers);
			return "/readers/readers-list";
		}
		
		@RequestMapping("/findById")
		public String findById(String id,Model model){
			IReaderService readerService=new ReaderServiceImpl();
			Reader reader = readerService.findById(id);
			model.addAttribute("reader", reader);
			return "/readers/readers-edit";
		}
		
		@RequestMapping("/getReadersById")
		public String getReadersById(String id,Model model){
			IReaderService readerService=new ReaderServiceImpl();
			Reader reader = readerService.findById(id);
			model.addAttribute("reader", reader);
			return "/readers/user-readers-list";
		}
		
		@RequestMapping("/findById2")
		public String findById2(String id,Model model){
			IReaderService readerService=new ReaderServiceImpl();
			Reader reader = readerService.findById(id);
			model.addAttribute("reader", reader);
			return "/readers/user-readers-edit";
		}
		
		@RequestMapping("/readerUpdate")
		public String readerUpdate(Reader reader,Model model){
			IReaderService readerService=new ReaderServiceImpl();
			reader.setReaderPaw(MD5Util.encode(reader.getReaderPaw()));
			readerService.update(reader);
			List<Reader> readers =  readerService.findAllReaders();
			model.addAttribute("readers", readers);
			return "/readers/readers-list";
		}
		
		@RequestMapping("/userreaderUpdate")
		public String userreaderUpdate(Reader reader,Model model){
			IReaderService readerService=new ReaderServiceImpl();
			reader.setReaderPaw(MD5Util.encode(reader.getReaderPaw()));
			readerService.update(reader);
			Reader reader1 = readerService.findById(reader.getId()+"");
			model.addAttribute("reader", reader1);
			return "/readers/user-readers-list";
		}
		
		@RequestMapping("/readerDelete")
		public String readerDelete(String id,Model model){
			IReaderService readerService=new ReaderServiceImpl();
			readerService.delete(id);
			List<Reader> readers =  readerService.findAllReaders();
			model.addAttribute("readers", readers);
			return "/readers/readers-list";
		}
		
		@RequestMapping("/findById3")
		public String findById3(String id,Model model){
			IReaderService readerService=new ReaderServiceImpl();
			Reader reader = readerService.findById(id);
			model.addAttribute("reader", reader);
			return "/readers/user-readers-passwd";
		}
		
		@RequestMapping("/userUpdatepaw")
		public void adminEdit(Reader reader,HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
			request.setCharacterEncoding("utf-8");
			response.setCharacterEncoding("UTF-8");
			response.setContentType("text/html;charset=UTF-8");
			HttpSession session = request.getSession();
			IReaderService readerService=new ReaderServiceImpl();
			reader.setReaderPaw(MD5Util.encode(reader.getReaderPaw()));
			readerService.update(reader);
			session.invalidate();
			response.getWriter().write("<script charset='UTF-8'>alert(\"修改成功，请重新登录！\");" +
	                "location.href='../login.jsp';</script>");
		}
		
		@RequestMapping("/logout")
		public void logout(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
				HttpSession session = request.getSession();
					session.invalidate();
					response.sendRedirect("../login.jsp");
			}
}
