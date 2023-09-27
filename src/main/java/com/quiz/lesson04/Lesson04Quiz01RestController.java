package com.quiz.lesson04;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.quiz.lesson04.bo.SellerBO;
import com.quiz.lesson04.domain.Seller;

@RequestMapping("/lesson04/quiz01")
@Controller
public class Lesson04Quiz01RestController {
	
	@Autowired
	private SellerBO sellerBO;
	
	// http://localhost/lesson04/quiz01/add-seller-view
	@GetMapping("/add-seller-view")
	public String addSellerView () {
		return "lesson04/addSeller";
	}
	
	
	@PostMapping("/add-seller")
	public String addSeller(
			@RequestParam("nickname") String nickname,
			@RequestParam(value = "profileImageUrl", required = false) String profileImageUrl,
			@RequestParam(value = "temperature", required = false) Double temperature){
		
		// db insert
				
		sellerBO.addSeller(nickname, profileImageUrl, temperature);
		return "lesson04/afterAddSeller";
	}
	
	// 2번 문제 : 최신 가입자 한명 출력 페이지
	// http://localhost/lesson04/quiz01/seller-info?id=1
	@GetMapping("/seller-info")
	public String sellerinfo(Model model,
			@RequestParam(value="id", required=false) Integer id) {
		Seller seller = null;
		if (id == null) {
			seller = sellerBO.getLatestSeller();
		} else {
			seller = sellerBO.getSeller(id);
		}
		model.addAttribute("seller", seller);
		return "lesson04/sellerInfo";
	}
	
	
}
	
	
	

