package com.quiz.lesson01;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/lesson01/quiz02")

public class Lesson01Quiz02RestController {
	
	// Alt Shift R => 동시수정 단축키
	
	//요청 url :  http://localhost:8080/lesson01/quiz02/1
	@RequestMapping("/1")
	
	public List<Movie> quiz02_1 () {
		
		List<Movie> list = new ArrayList<>();
		
		Movie movieInfo = new Movie();
		
		movieInfo.setRate(15);
		movieInfo.setDirector("봉준호");
		movieInfo.setTime(131);
		movieInfo.setTitle("기생충");
		list.add(movieInfo);
		
		movieInfo = new Movie();
		
		movieInfo.setRate(0);
		movieInfo.setDirector("로베르토 베니니");
		movieInfo.setTime(116);
		movieInfo.setTitle("인생은 아름다워");
		list.add(movieInfo);
		
		movieInfo = new Movie();
		
		movieInfo.setRate(12);
		movieInfo.setDirector("크리스토퍼 놀란");
		movieInfo.setTime(147);
		movieInfo.setTitle("인셉션");
		list.add(movieInfo);
		
		movieInfo = new Movie();
		
		movieInfo.setRate(19);
		movieInfo.setDirector("윤종빈");
		movieInfo.setTime(133);
		movieInfo.setTitle("범죄와의 전쟁 : 나쁜놈들 전성시대");
		list.add(movieInfo);
		
		movieInfo = new Movie();
		
		movieInfo.setRate(15);
		movieInfo.setDirector("프란시스 로렌스");
		movieInfo.setTime(137);
		movieInfo.setTitle("헝거게임");
		list.add(movieInfo);
		
		return list;
		
	}
		
	
	//요청 url :  http://localhost:8080/lesson01/quiz02/2
	@RequestMapping("/2")
	
	public List<Board> quiz02_2 () {
		List<Board> target = new ArrayList<>();
		
		Board board = new Board();
		
		board.setTitle("안녕하세요 가입인사 드립니다.");
		board.setUser("hagulu");
		board.setContent("안녕하세요. 가입했어요. 앞으로 잘 부탁 드립니다. 활동 열심히 하겠습니다.");
		target.add(board);
		
		board = new Board();
		board.setTitle("헐 대박");
		board.setUser("bada");
		board.setContent("오늘 목요일이 었어... 금요일인줄");
		target.add(board);
		
		board = new Board();
		board.setTitle("오늘 데이트 한 이야기 해드릴게요.");
		board.setUser("dulumary");
		board.setContent("....");
		target.add(board);
		
		return target;
		
	}
	
	
	// 요청 URL : http://localhost:8080/lesson01/quiz02/3
	@RequestMapping("/3")
	
	public ResponseEntity<Board> quiz02_3 () {
		
		Board board = new Board();
		board.setTitle("안녕하세요 가입인사 드립니다");
		board.setUser("hagulu");
		board.setContent("안녕하세요. 가입했어요. 앞으로 잘 부탁 드립니다. 활동 열심히 하겠습니다.");
		
		return new ResponseEntity<>(board, HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	
	
}
