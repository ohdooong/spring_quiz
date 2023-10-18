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
	
	public void addBookMark (String name, String url) {
		bookmarkMapper.insertBookMark(name, url);
	}
	
	public List<BookMark> getBookMarks () {
		return bookmarkMapper.selectBookMarks();
	}
	
	public boolean existUrlByUrl(String url) {
		return bookmarkMapper.existUrlByUrl(url);
	}
	
	public void deleteDataById (int id) {
		bookmarkMapper.deleteDataById(id);
	}
	
	// input:rel ::::::: output:Bookmark 단 건이거나, 널이거나
	// Too many result => 단건으로 이턴하지만 결과는 List로 나왔을 때
	
	public BookMark getBookmarkByUrl(String url) {
		return bookmarkMapper.selectBookmarkByUrl(url);
	}
	
}
