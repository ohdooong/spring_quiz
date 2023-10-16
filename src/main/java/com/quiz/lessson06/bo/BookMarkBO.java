package com.quiz.lessson06.bo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quiz.lessson06.domain.BookMark;
import com.quiz.lessson06.mapper.BookMarkMapper;

@Service
public class BookMarkBO {
	
	@Autowired
	private BookMarkMapper bookmarkMapper;
	
	public void addBookMark (String title, String address) {
		bookmarkMapper.insertBookMark(title, address);
	}
	
	public List<BookMark> getBookMarks () {
		return bookmarkMapper.selectBookMarks();
	}
	
	
}
