package com.quiz.lesson07.bo;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quiz.lesson07.entity.CompanyEntity;
import com.quiz.lesson07.repository.CompanyRepository;

@Service
public class CompanyBO {
	
	@Autowired
	private CompanyRepository companyRepository;
	
	
	// input : 4개 파라미터, output:방금 인서트 된 엔티티
	public CompanyEntity addCompany (String name, String business, String scale, int headcount) {
		
		return companyRepository.save(
					CompanyEntity.builder()
					.name(name)
					.business(business)
					.scale(scale)
					.headcount(headcount).build()      // 객체를 만들어서 setter 역할까지 해줌
				);
	}
	
	
}
