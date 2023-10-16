package com.quiz.lessson06;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.quiz.lessson06.bo.BookMarkBO;
import com.quiz.lessson06.domain.BookMark;

@RequestMapping("/lesson06/quiz01")
@Controller
public class Lesson06Controller {
	
	@Autowired
	private BookMarkBO bookmarkBO;
	
	
	// http://localhost/lesson06/quiz01/add-bookmark-view
	@GetMapping("/add-bookmark-view")
	public String addBookMark() {
		return "lesson06/addBookmark";
	}
	
	// http://localhost/lesson06/quiz01/add-book-mark
	@PostMapping("/add-bookmark")
	@ResponseBody
	public String addBookMark(
			@RequestParam("title") String title,
			@RequestParam("address") String address) {
		
		bookmarkBO.addBookMark(title, address);
		
		return "성공";
	}
	
	// http://localhost/lesson06/quiz01/add-result
	@GetMapping("/add-result")
	public String addResult (Model model) {
		
		List<BookMark> bookmarks = new ArrayList<>();
		bookmarks = bookmarkBO.getBookMarks();
		
		model.addAttribute("bookmarks", bookmarks);
		
		return "lesson06/addResult";
	}
	
	
}
