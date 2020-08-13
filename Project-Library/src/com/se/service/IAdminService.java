package com.se.service;

import java.util.List;

import com.se.bean.Admin;



public interface IAdminService {
	List<Admin> findAlladmins();
	void save(Admin a );
	
	Admin findById(String id);
	Admin findBynp(Admin logadmin);
	
	void update(Admin a );
	void delete(String id);
}
