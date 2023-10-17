package com.quiz.lessson06;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

@RequestMapping("/lesson06")
@Controller
public class Lesson06Controller {
	
	@Autowired
	private BookMarkBO bookmarkBO;
	
	
	// http://localhost/lesson06/quiz01/add-bookmark-view
	@GetMapping("/quiz01/add-bookmark-view")
	public String addBookMarkView() {
		return "lesson06/addBookmark";
	}
	
	// http://localhost/lesson06/quiz01/add-book-mark
	@ResponseBody
	@PostMapping("/quiz01/add-bookmark") // ajax가 하는 요청
	public Map<String, Object> addBookMark( //JSON으로 응답값 내리기 위해
			@RequestParam("name") String name,
			@RequestParam("url") String url) {
		
		// db insert
		bookmarkBO.addBookMark(name, url);
		
		// 응답값 : JSON String   => 응답값은 무조건 String이거나 JSON이어야 함.
//		{
//			"code" : 200,
//			"result" : "success"
//		
//		}
		Map<String, Object> result = new HashMap<>();
		
		result.put("code",200);
		result.put("result","success");
		
		return result;
	}
	
	// http://localhost/lesson06/quiz01/add-result
	@GetMapping("/quiz01/add-result")
	public String addResult (Model model) {
		
		List<BookMark> bookmarks = new ArrayList<>();
		bookmarks = bookmarkBO.getBookMarks();
		
		model.addAttribute("bookmarks", bookmarks);
		
		return "lesson06/addResult";
	}	
	
	// ====================== quiz02 ========================
	
	// http://localhost/lesson06/quiz02/is-duplication => AJAX로부터의 요청
	@ResponseBody
	@GetMapping("/quiz02/is-duplication")
	public Map<String, Object> isDuplication(
			@RequestParam("url") String url) {
		
		boolean isDuplicated = bookmarkBO.existUrlByUrl(url);
		
		// 응답
		Map<String, Object> result = new HashMap<>();
		result.put("code", 200);
		result.put("is_duplication", isDuplicated);
		
		
		return result;
	}
	
	@ResponseBody
	@RequestMapping("/quiz02/delete-data")
	public Map<String, Object> deleteData(
			@RequestParam("id") int id) {
		
		// db 삭제
		bookmarkBO.deleteDataById(id);
		// 응답
		Map<String, Object> result = new HashMap<>();
		result.put("code", 200);
		result.put("is_delete", "success");
		
		return result;
	}
	
	
	
	
	
}