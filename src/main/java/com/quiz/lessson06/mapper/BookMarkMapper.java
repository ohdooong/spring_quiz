package com.quiz.lessson06.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.quiz.lessson06.domain.BookMark;

@Repository
public interface BookMarkMapper {
	
	public void insertBookMark (
			@Param("name") String name,
			@Param("url") String url);
	
	public List<BookMark> selectBookMarks ();
	
	public boolean existUrlByUrl(String url);
	
	public void deleteDataById (int id);
	
}
