package com.se.service;

import java.util.List;

import com.se.bean.UserType;



public interface IUserTypeService {
	List<UserType> findAllUserTypes();
	void save(UserType u); 
	
	UserType findById(String id);
	List<UserType> findByUserType(String username);
	
	void update(UserType u);
	
	void delete(String id);
}
