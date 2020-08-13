package com.se.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.se.bean.Admin;
import com.se.bean.Reader;
import com.se.service.IAdminService;
import com.se.service.IReaderService;
import com.se.service.impl.AdminServiceImpl;
import com.se.service.impl.ReaderServiceImpl;
import com.se.util.MD5Util;



@Controller
@RequestMapping("/user")
public class UserController extends HttpServlet{
	
	@RequestMapping("/login")
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		IAdminService as = new AdminServiceImpl();
		IReaderService re=new ReaderServiceImpl();
		HttpSession session = request.getSession();

		  //PrintWriter out = response.getWriter();
		  //out.flush();
		    //out.println("<script>");
		    //out.println("alert('此用户名已存在，请重新输入！');");
		    //out.println("</script>");
			String name = request.getParameter("username");
			String password = MD5Util.encode(request.getParameter("password"));
			Admin logadmin=new Admin();
			logadmin.setUsername(name);
			logadmin.setPassword(password);
			String usertype = request.getParameter("usertype");
			Admin a = as.findBynp(logadmin);
			Reader r=re.getReaderBynp(name, password);
			
			
			
			if("admin".equals(usertype) && a != null) {
				String n = a.getUsername();
				String p = a.getPassword();
				if(n.equals(name) && p.equals(password)) {
					session.setAttribute("admin", a);
					response.sendRedirect("../main.jsp");
				}else {
					response.getWriter().write("<script charset='UTF-8'>alert(\"用户名或密码错误！\");" +
	                        "location.href='../login.jsp';</script>");
				}
			}else if("user".equals(usertype) && r != null) {
				String n = r.getReaderName();
				String p = r.getReaderPaw();
				if(n.equals(name) && p.equals(password)) {
					session.setAttribute("userReader", r);
					response.sendRedirect("../userlogin.jsp");
				}else {
					response.getWriter().write("<script charset='UTF-8'>alert(\"用户名或密码错误！\");" +
	                        "location.href='../login.jsp';</script>");
				}
			}else{
				response.getWriter().write("<script charset='UTF-8'>alert(\"用户名或密码错误！\");" +
                        "location.href='../login.jsp';</script>");
			}
			
	}
	
	@RequestMapping("/logout")
	public void logout(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			HttpSession session = request.getSession();
				session.invalidate();
				response.sendRedirect("../login.jsp");
		}
	@RequestMapping("/relogin")
	public void relogin(HttpServletRequest request, HttpServletResponse response)  throws ServletException, IOException {
			HttpSession session = request.getSession();
				session.invalidate();
				response.sendRedirect("../login.jsp");
		}
	
	@RequestMapping("/findById")
	public String findById(String id,Model model) {
		IAdminService adminService=new AdminServiceImpl();
			Admin readmin =  adminService.findById(id);
			readmin.setPassword(" ");
			model.addAttribute("readmin", readmin);
			return "admin/admin-edit";
		}
	@RequestMapping("/adminEdit")
	public void adminEdit(Admin admin,HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		HttpSession session = request.getSession();
		IAdminService adminService = new AdminServiceImpl();
		admin.setPassword(MD5Util.encode(admin.getPassword()));
		adminService.update(admin);
		session.invalidate();
		response.getWriter().write("<script charset='UTF-8'>alert(\"修改成功，请重新登录！\");" +
                "location.href='../login.jsp';</script>");
	}
}

		
