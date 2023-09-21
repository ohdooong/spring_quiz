package com.quiz.lesson02.mapper;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.quiz.lesson02.domain.Store;

// DAO = Mapper
@Repository
public interface StoreMapper {
	
	// input (BO-Service 요청) : x
	// output (BO-Service 결과 반환) : List<Store>
	public List<Store> selectStoreList();
}
