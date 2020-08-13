package com.se.dao;

import java.util.List;

import com.se.bean.UserType;




public interface IUserTypeDao {
	List<UserType> getAllUserTypes();
	void save(UserType u); 
	UserType getUserTypeById(String id);
	List<UserType> getUserTypeByUser(String username);
	void update(UserType b);
	void delete(String id);
}
