package com.quiz.lessson06.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.quiz.lessson06.domain.BookMark;

@Repository
public interface BookMarkMapper {
	
	public void insertBookMark (
			@Param("title") String title,
			@Param("address") String address);
	
	public List<BookMark> selectBookMarks ();
	
}
