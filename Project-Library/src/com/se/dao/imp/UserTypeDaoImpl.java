package com.se.dao.imp;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.se.bean.UserType;
import com.se.dao.IUserTypeDao;
import com.se.util.MybatisUtils;

public class UserTypeDaoImpl implements IUserTypeDao{
	private static SqlSession session;
	private static String statement;
	
	public List<UserType> getAllUserTypes() {
		session=MybatisUtils.getFactory();
		statement = "rjxy.userMapper1"+".selectAllUserType";
		List<UserType> list=session.selectList(statement);
		return list;
	}

	
	public void save(UserType u) {
		session=MybatisUtils.getFactory();
		statement = "rjxy.userMapper1"+".insertUserType";
		session.insert(statement,u);
		session.close();
	}

	
	public UserType getUserTypeById(String id) {
		session=MybatisUtils.getFactory();
		statement = "rjxy.userMapper1"+".getUserType";
		UserType u = session.selectOne(statement,id);
		return u;
	}

	
	public List<UserType> getUserTypeByUser(String username) {
		
		return null;
	}

	
	public void update(UserType u) {
		session=MybatisUtils.getFactory();
		statement = "rjxy.userMapper1"+".updateUserType";
		session.update(statement, u);
		session.close();
	}

	
	public void delete(String id) {
		session=MybatisUtils.getFactory();
		statement = "rjxy.userMapper1"+".deleteUserType";
		session.delete(statement,id);
		session.close();
	}

	

}
