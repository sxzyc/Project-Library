package com.se.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.se.bean.LoanInfo;
import com.se.dao.ILoanInfoDao;
import com.se.dao.imp.LoanInfoDaoImpl;
import com.se.service.ILoanInfoService;


public class LoanInfoServiceImpl implements ILoanInfoService{
	ILoanInfoDao loanInfodao=new LoanInfoDaoImpl();

	public List<LoanInfo> FindAll() {
		List<LoanInfo> list = new ArrayList<LoanInfo>();
		list = loanInfodao.FindAll();
		return list;
	}

	public LoanInfo Select(String id) {
		LoanInfo l=new LoanInfo();
		l=loanInfodao.Select(id);
		return l;
	}

	public void save(LoanInfo l) {
		loanInfodao.save(l);
		
	}

	public void Delete(String id) {
		loanInfodao.Delete(id);
		
	}

	public void Update(LoanInfo l) {
		loanInfodao.Update(l);
		
	}
	
	public List<LoanInfo> findByLoanInfo(String readername){
		List<LoanInfo> list = new ArrayList<LoanInfo>();
		list = loanInfodao.findByLoanInfo(readername);
		return list;
	}
}
