package com.se.dao;

import java.util.List;

import com.se.bean.LoanInfo;

public interface ILoanInfoDao {
	List<LoanInfo> FindAll();
	LoanInfo Select(String id);
	void save(LoanInfo l);
	void Update(LoanInfo l);
	void Delete(String id);
	List<LoanInfo> findByLoanInfo(String readername);
}
