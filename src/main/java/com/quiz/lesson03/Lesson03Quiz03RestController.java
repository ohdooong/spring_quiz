package com.quiz.lesson03;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.quiz.lesson03.bo.RealEstateBO;

@RestController // : String bean만들기
public class Lesson03Quiz03RestController {
	
	@Autowired
	private RealEstateBO realestateBO;
	
	// 요청 URL: http://localhost/lesson03/quiz03/1?id=8&price=70000&type=전세
	@RequestMapping("/lesson03/quiz03/1")
	public String quiz03_1 (
			@RequestParam("id") int id, 
			@RequestParam("price") int price, 
			@RequestParam("type") String type) {
		
		int rowCount = realestateBO.updateRealEstateById(id, price, type);
		return "수정 성공 : " + rowCount;
	}
	
}
