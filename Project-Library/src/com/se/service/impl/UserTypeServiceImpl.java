package com.se.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.se.bean.UserType;
import com.se.dao.IUserTypeDao;
import com.se.dao.imp.UserTypeDaoImpl;
import com.se.service.IUserTypeService;

public class UserTypeServiceImpl implements IUserTypeService{
	IUserTypeDao usertypedao=new UserTypeDaoImpl();
	
	public List<UserType> findAllUserTypes() {
		List<UserType> list = new ArrayList<UserType>();
		list = usertypedao.getAllUserTypes();
		return list;
	}

	
	public void save(UserType u) {
		usertypedao.save(u);
		
	}

	
	public UserType findById(String id) {
		UserType usertype=usertypedao.getUserTypeById(id);
		return usertype;
	}

	
	public List<UserType> findByUserType(String username) {
		
		return null;
	}

	
	public void update(UserType u) {
		usertypedao.update(u);
	}

	
	public void delete(String id) {
		usertypedao.delete(id);
	}


}
