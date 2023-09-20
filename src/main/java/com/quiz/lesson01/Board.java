package com.quiz.lesson01;

// 일반 자바 bean

public class Board {
	// 필드
	private String title;
	private String user;
	private String content;
	
	// 생성자로도 이용가능
	
	// 기본 생성자
	public Board () {
		
	}
	
	// 파라미터 생성자
	public Board (String title, String user, String content) {
		this.title = title;
		this.user = user;
		this.content = content;
	}
	
	
	
	
	// 메서드
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	
	
	
}
