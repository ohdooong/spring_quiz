package com.quiz.lesson03.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.quiz.lesson03.domain.RealEstate;

@Repository
public interface RealEstateMapper {

	public RealEstate selectRealEstateById(int id);
	
	public List<RealEstate> selectRealEstateListByRentPrice(
			@Param("rentPrice1") int rentPrice);
	
	public int insertRealEstate(RealEstate realestate);
	
	public int insertRealEstateAsField (
			@Param("realtorId") int realtorId123125,
			@Param("address") String address123125, 
			@Param("area") int area, 
			@Param("type") String type, 
			@Param("price") int price, 
			@Param("rentPrice") Integer rentPrice);
}










