package com.se.service;

import java.util.List;

import com.se.bean.LoanInfo;


public interface ILoanInfoService {
	List<LoanInfo> FindAll();
	LoanInfo Select(String id);
	void save(LoanInfo l);
	void Delete(String id);
	void Update(LoanInfo l);
	List<LoanInfo> findByLoanInfo(String readername);
}
