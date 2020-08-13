package com.se.dao;

import java.util.List;

import com.se.bean.Admin;


public interface IAdminDao {
	List<Admin> getAllAdmin();
	void save(Admin a); 
	
	Admin getAdminById(String id);
	Admin getAdminBynp(Admin logadmin);
	void update(Admin a);
	
	void delete(String id);
	
}	
