package com.quiz.lesson02.bo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quiz.lesson02.domain.Store;
import com.quiz.lesson02.mapper.StoreMapper;

@Service	// spring bean이 됨
public class StoreBO {
	
	@Autowired	// spring bean(객체) 가져옴
	private StoreMapper storeMapper; // DI
	
	// input(컨트롤러로부터 요청 받음): 아무것도 안줌
	// output(컨트롤러한테 반환): List<Store>
	public List<Store> getStoreList() {
		return storeMapper.selectStoreList();
	}
	
	
	
}
