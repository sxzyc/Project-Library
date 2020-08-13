package com.se.service.impl;

import java.util.List;

import com.se.bean.Admin;
import com.se.dao.IAdminDao;
import com.se.dao.imp.AdminDaoImpl;
import com.se.service.IAdminService;



public class AdminServiceImpl  implements IAdminService{
	
	IAdminDao ad = new AdminDaoImpl();
	public List<Admin> findAlladmins() {
		List<Admin> list = ad.getAllAdmin();
		return list;
	}
	
	public void save(Admin a) {
		ad.save(a);
	}
	
	public Admin findById(String id) {
		Admin admin = ad.getAdminById(id);
		return admin;
	}

	public Admin findBynp(Admin logadmin) {
		Admin admin = ad.getAdminBynp(logadmin);
		return admin;
	}
	public void update(Admin a) {
		ad.update(a);
	}
	
	public void delete(String id) {
		ad.delete(id);
	}

}
