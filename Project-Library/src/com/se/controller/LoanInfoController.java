package com.se.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.se.bean.LoanInfo;
import com.se.service.ILoanInfoService;
import com.se.service.impl.LoanInfoServiceImpl;

@Controller
@RequestMapping("/loanInfo")
public class LoanInfoController {
	@RequestMapping("/loanInfoList")
	public String loanInfoList(Model model) {
	ILoanInfoService LoanInfoService=new LoanInfoServiceImpl();
	List<LoanInfo> loanInfos=LoanInfoService.FindAll();
	model.addAttribute("loanInfos", loanInfos);
	return "loanInfos/loanInfos-list";
}
	@RequestMapping("/loanInfoPWD")
	public String loanInfoPWD() {
		return "loanInfos/loanInfos-add";
	}
	
	@RequestMapping("/loanInfoAdd")
	public String loanInfoAdd(LoanInfo loanInfo,Model model){
			ILoanInfoService LoanInfoService=new LoanInfoServiceImpl();
			LoanInfoService.save(loanInfo);
			List<LoanInfo> loanInfos=LoanInfoService.FindAll();
			model.addAttribute("loanInfos", loanInfos);
			return "/loanInfos/loanInfos-list";
		}
	
	@RequestMapping("/loanInfoDelete")
	public String loanInfosDelete(String id, Model model) {
			ILoanInfoService LoanInfoService=new LoanInfoServiceImpl();
			LoanInfoService.Delete(id);
			List<LoanInfo> loanInfos=LoanInfoService.FindAll();
			model.addAttribute("loanInfos", loanInfos);
			return "/loanInfos/loanInfos-list";
		}
	
	@RequestMapping("/findById")
	public String findById(String id,Model model){
			ILoanInfoService LoanInfoService=new LoanInfoServiceImpl();
			LoanInfo loanInfo = LoanInfoService.Select(id);
			model.addAttribute("loanInfo", loanInfo);
			return "/loanInfos/loanInfos-edit";
		}
	
	@RequestMapping("/loanInfoEdit")
	public String readerTypeEdit(LoanInfo loanInfo,Model model){
			ILoanInfoService LoanInfoService=new LoanInfoServiceImpl();
			LoanInfoService.Update(loanInfo);
			List<LoanInfo> loanInfos=LoanInfoService.FindAll();
			model.addAttribute("loanInfos", loanInfos);
			return "/loanInfos/loanInfos-list";
		}
	
	@RequestMapping("/userloanInfoList")
	public String userloanInfoList(String readername,Model model) {
		ILoanInfoService LoanInfoService=new LoanInfoServiceImpl();
		List<LoanInfo> loanInfos=LoanInfoService.findByLoanInfo(readername);
		model.addAttribute("loanInfos", loanInfos);
		return "loanInfos/user-loanInfos-list";
	}
}
