package com.quiz.lesson07;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.quiz.lesson07.entity.RecruitEntity;
import com.quiz.lesson07.repository.RecruitRepository;

@RequestMapping("/lesson07/quiz02")
@RestController
public class Lesson07Quiz02RestController {
	
	@Autowired
	private RecruitRepository recruitRepository;
	
	@GetMapping("/1")
	public RecruitEntity quiz02_1() {
		return recruitRepository.findById(8).orElse(null);
	}
	
	@GetMapping("/2")
	public List<RecruitEntity> quiz02_2(
			@RequestParam("corporationId") int companyId) {
		
		return recruitRepository.findByCompanyId(companyId);
	}
	
	@GetMapping("/3")
	public List<RecruitEntity> quiz02_3 () {
		
		return recruitRepository.findByPositionAndType();
	}
	
	
	
	
	
	
	
	
	@GetMapping("/7")
	public List<RecruitEntity> quiz02_7 () {
		return recruitRepository.findByDeadlineAfterAndSalaryGreaterThanEqualAndTypeOrderBySalaryDesc("2026-04-10",8100,);
	}
	
	
}
