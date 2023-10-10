package com.quiz.lesson05;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class Lesson05Controller {
	
	//요청 url : http://localhost/lesson05/quiz01
	@GetMapping("/lesson05/quiz01")
	public String quiz01 () {
		return "lesson05/quiz01";
	}
	
	
	
}
