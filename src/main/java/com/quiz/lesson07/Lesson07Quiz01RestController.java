package com.quiz.lesson07;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.quiz.lesson07.bo.CompanyBO;
import com.quiz.lesson07.entity.CompanyEntity;

@RequestMapping("/lesson07/quiz01")
@RestController
public class Lesson07Quiz01RestController {
	
	@Autowired
	private CompanyBO companyBO;
	
	@GetMapping("/sacw1")
	public CompanyEntity save1() {
		
		String name = "한솔 PNS";
		String business = "IT";
		String scale = "대기업";
		int headcount = 200;
		
		return companyBO.addCompany(name, business, scale, headcount);
	}
	
	@GetMapping("/save2")
	public CompanyEntity save2() {
//		회사명 : 버블팡
//		사업내용 : 여신 금융업
//		규모 : 대기업
//		사원수 : 6834명
		return companyBO.addCompany("버블팡", "여신 금융업", "대기업", 6834);
	}
	
	@GetMapping("/update")
	public CompanyEntity update() {
		// id:8, 중소기업, 34
		return companyBO.updateCompanyScaleHeadcountById(8, "중소기업", 34);
	}
	
	@GetMapping("/delete")
	public String delete() {
		// id:8
		companyBO.deleteCompanyById(8);
		return "삭제 성공";
	}
	
	
	
}
