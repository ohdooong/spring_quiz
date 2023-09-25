package com.quiz.lesson03.bo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quiz.lesson03.domain.RealEstate;
import com.quiz.lesson03.mapper.RealEstateMapper;

@Service
public class RealEstateBO {

	@Autowired
	private RealEstateMapper realEstateMapper;
	
	// input: id(정수)
	// output: RealEstate
	public RealEstate getRealEstateById(int id) {
		return realEstateMapper.selectRealEstateById(id);
	}
	
	// input: rentPrice
	// output: List<RealEstate>
	public List<RealEstate> getRealEstateListByRentPrice(int rentPrice) {
		//return null;
		return realEstateMapper.selectRealEstateListByRentPrice(rentPrice);
	}
	
	// input : RealEstate 객체 (한건) 
	// output : int 성공된 행의 개수
	public int addRealEstate (RealEstate realestate) {
		return realEstateMapper.insertRealEstate(realestate);
	}
	
	// 
	
	public int addRealEstateAsField (int realtorId ,String address, int area, String type, int price, Integer rentPrice) {
		return realEstateMapper.insertRealEstateAsField(realtorId ,address, area, type, price, rentPrice);
	}
}











