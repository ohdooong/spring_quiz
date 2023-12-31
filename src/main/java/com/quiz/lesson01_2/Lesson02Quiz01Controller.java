package com.quiz.lesson01_2;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Lesson02Quiz01Controller {
	
	// 요청 URL: http://localhost/lesson01/quiz03/1
	
	@RequestMapping("/lesson01/quiz03/1")
	public String quiz03() {
		//jsp 경로 리턴
		//return "/WEB-INF/jsp/lesson01/quiz03.jsp";
		//			/WEB-INF/jsp/ 중간 경로.jsp  => 이 중간 경로가 return값이다.
		
		// @ResponseBody 어노테이션이 없을 때 String을 리턴하면
		// ViewResolver에 의해 리턴된 String 경로의 jsp view 화면을 찾고 태그가 ResponseBody에 담긴다.
		return "lesson01/quiz03";
	}
}
