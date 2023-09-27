package com.quiz.lesson04.bo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quiz.lesson04.domain.Seller;
import com.quiz.lesson04.mapper.SellerMapper;

@Service
public class SellerBO {
	
	@Autowired
	private SellerMapper sellerMapper;
	
	
	//input 3개 파라미터
	//output x
	public void addSeller (String nickname, String profileImageUrl, Double temperature) {
		sellerMapper.insertSeller(nickname, profileImageUrl, temperature);
	}
	
	// 조회
	// input : X
	// output : Seller
	public Seller getLatestSeller () {
		return sellerMapper.selectLatestSeller();
	}
	
	public Seller getSeller (int id) {
		return sellerMapper.selectSeller(id);
	}
	
	
}
