package com.se.util;

import java.io.InputStream;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MybatisUtils {
	public static SqlSession getFactory(){
		String resource = "conf.xml"; 
		
		InputStream reader=MybatisUtils.class.getClassLoader().getResourceAsStream(resource);
		 
		
SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(reader);
		
SqlSession session = factory.openSession(true);
		return session;
	}
}
