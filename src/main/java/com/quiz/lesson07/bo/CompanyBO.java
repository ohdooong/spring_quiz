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
	
	// input : 3개 파라미터		// output : 방금 변경된 그 Entity
	public CompanyEntity updateScaleHeadcountById (int id, int headcount ,String scale) {
		CompanyEntity company = companyRepository.findById(id).orElse(null);    // Optional 객체로 돌려줘서 결과가 없으면 null로 세팅한다는 뜻 
		
		if (company != null) {
			return companyRepository.save(company.toBuilder()
					.scale(scale)
					.headcount(headcount)
					.build());
		}
		return null;
	}
	
	// delete
	// input: id		output:x
	public void deleteById (int id) {
		Optional<CompanyEntity> companyOptional = companyRepository.findById(id);
		companyOptional.ifPresent(company -> companyRepository.delete(company));
		
	}
	
}
