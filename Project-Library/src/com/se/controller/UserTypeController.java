package com.se.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.se.bean.UserType;
import com.se.service.IUserTypeService;
import com.se.service.impl.UserTypeServiceImpl;

/**
 * @ClassName: UserTypeController
 * @Description:
 * @author: 赵越超
 * @date: 2020年4月19日 上午11:39:34
 * @param:
 */

@Controller
@RequestMapping("/userType")
public class UserTypeController {
	@RequestMapping("/userTypeList")
	public String userTypeList(Model model) {
		IUserTypeService userTypeService=new UserTypeServiceImpl();
		List<UserType> lists =  userTypeService.findAllUserTypes();
		model.addAttribute("lists", lists);
		return "userType/userType-list";
	}
	
	@RequestMapping("/userTypePWD")
	public String bookTypePWD() {
		return "userType/userType-add";
	}
		@RequestMapping("/userTypeAdd")
		public String userTypeAdd(UserType userType,Model model){
			IUserTypeService userTypeService=new UserTypeServiceImpl();
			userTypeService.save(userType);
			List<UserType> lists =  userTypeService.findAllUserTypes();
			model.addAttribute("lists", lists);
			return "/userType/userType-list";
		}
		
		@RequestMapping("/findById")
		public String findById(String id,Model model){
			IUserTypeService userTypeService=new UserTypeServiceImpl();
			UserType userType = userTypeService.findById(id);
			model.addAttribute("userType", userType);
			return "/userType/userType-edit";
		}
		
		@RequestMapping("/userTypeUpdate")
		public String userTypeUpdate(UserType userType,Model model){
			IUserTypeService userTypeService=new UserTypeServiceImpl();
			userTypeService.update(userType);
			List<UserType> lists =  userTypeService.findAllUserTypes();
			model.addAttribute("lists", lists);
			return "/userType/userType-list";
		}
		
		@RequestMapping("/userTypeDelete")
		public String userTypeDelete(String id,Model model){
			IUserTypeService userTypeService=new UserTypeServiceImpl();
			userTypeService.delete(id);
			List<UserType> lists =  userTypeService.findAllUserTypes();
			model.addAttribute("lists", lists);
			return "/userType/userType-list";
		}
}
