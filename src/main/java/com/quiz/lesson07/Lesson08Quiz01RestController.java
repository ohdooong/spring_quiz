package com.quiz.lesson07;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.quiz.lesson07.bo.CompanyBO;
import com.quiz.lesson07.entity.CompanyEntity;

@RequestMapping("/lesson07/quiz01")
@RestController
public class Lesson08Quiz01RestController {
	
	@Autowired
	private CompanyBO companyBO;
	
	@GetMapping("/1")
	public CompanyEntity create() {
		
		String name = "한솔 PNS";
		String business = "IT";
		String scale = "대기업";
		int headcount = 200;
		
		return companyBO.addCompany(name, business, scale, headcount);
	}
	
	
	
	
}
