package com.se.dao.imp;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.se.bean.LoanInfo;
import com.se.dao.ILoanInfoDao;
import com.se.util.MybatisUtils;


public class LoanInfoDaoImpl implements ILoanInfoDao{
	private static SqlSession session;
	private static String statement;

	public List<LoanInfo> FindAll() {
		session=MybatisUtils.getFactory();
		statement = "rjxy.userMapper1"+".selectAllLoanInfo";
		List<LoanInfo> list=session.selectList(statement);
		return list;
	}

	public LoanInfo Select(String id) {
		session=MybatisUtils.getFactory();
		statement = "rjxy.userMapper1"+".getLoanInfo";
		LoanInfo l=session.selectOne(statement,id);
		return l;
	}
	
	
	public void save(LoanInfo l) {
		session=MybatisUtils.getFactory();
		statement = "rjxy.userMapper1"+".insertLoanInfo";
		session.insert(statement,l);
		session.close();
	}

	public void Update(LoanInfo l) {
		session=MybatisUtils.getFactory();
		statement = "rjxy.userMapper1"+".updateLoanInfo";
		session.update(statement, l);
		session.close();
		
	}

	public void Delete(String id) { 
		session=MybatisUtils.getFactory();
		statement = "rjxy.userMapper1"+".deleteLoanInfo";
		session.delete(statement, id);
		session.close();
	}
	
	public List<LoanInfo> findByLoanInfo(String readername){
		session=MybatisUtils.getFactory();
		statement = "rjxy.userMapper1"+".getAllLoanInfo";
		List<LoanInfo> list=session.selectList(statement,readername);
		return list;
	}
}

