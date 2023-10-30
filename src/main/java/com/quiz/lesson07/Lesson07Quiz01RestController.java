package com.quiz.lesson07;

import java.util.List;

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
	
	@GetMapping("/1")
	public CompanyEntity quiz01_1() {
		
		String name = "한솔 PNS";
		String business = "IT";
		String scale = "대기업";
		int headcount = 200;
		
		return companyBO.addCompany(name, business, scale, headcount);
	}
	
	@GetMapping("/save1")
	public CompanyEntity save1(){
		
		String name = "넥손";
		String business = "컨텐츠 게임";
		String scale = "대기업";
		int headcount = 3585;
		
		return companyBO.addCompany(name, business, scale, headcount);
	}
	
	@GetMapping("/save2")
	public CompanyEntity save2(){
//		회사명 : 버블팡
//		사업내용 : 여신 금융업
//		규모 : 대기업
//		사원수 : 6834명
		
		String name = "버블팡";
		String business = "여신 금융업";
		String scale = "대기업";
		int headcount = 6834;
		
		return companyBO.addCompany(name, business, scale, headcount);
	}
	
	// http://localhost:8050/lesson07/quiz01/update
	@GetMapping("/update")
	public CompanyEntity update() {
		return companyBO.updateScaleHeadcountById(9, 34,"중소 기업");
	}
	
	@GetMapping("/delete")
	public String delete() {
		companyBO.deleteById(9);
		return "삭제 완료";
	}
	
}
