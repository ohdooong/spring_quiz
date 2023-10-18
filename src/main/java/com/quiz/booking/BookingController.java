package com.quiz.booking;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BookingController {
	
	
	// 통나무 펜션 메인 홈페이지
	// URL : http://localhost/booking/booking-main
	@GetMapping("/booking/booking-main")
	public String bookingMain() {
		return "booking/bookingMainPage";
	}
	
	// URL : http://localhost/booking/reservation-List
	@GetMapping("/booking/reservation-List")
	public String reservationList () {
		return "booking/reservationList";
	}
	
	
}
