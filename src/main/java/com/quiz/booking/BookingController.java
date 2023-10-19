package com.quiz.booking;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.quiz.booking.bo.BookingBO;
import com.quiz.booking.domain.Booking;

@Controller
public class BookingController {
	
	@Autowired
	private BookingBO bookingBO;
	
	
	
	// 통나무 펜션 메인 홈페이지
	// URL : http://localhost/booking/booking-main
	@GetMapping("/booking/booking-main")
	public String bookingMain() {
		return "booking/bookingMainPage";
	}
	
	// URL : http://localhost/booking/reservation-List
	@GetMapping("/booking/reservation-List")
	public String reservationList (Model model) {
		
		List<Booking> bookingList = new ArrayList<>();
		bookingList = bookingBO.getBookingList();
		
		model.addAttribute("bookingList", bookingList);
		
		return "booking/reservationList";
	}
	
	
	// URL : http://localhost/booking/add-booking-view
	@GetMapping("/booking/add-booking-view")
	public String addBookingView() {
		return "booking/addBooking";
	}
	
	//예약 추가 - AJAX 요청
	@ResponseBody
	@PostMapping("/booking/add-booking")
	public Map<String, Object> addBooking(
			@RequestParam("name") String name,
			@RequestParam("headcount") int headcount,
			@RequestParam("day") int day,
			@RequestParam("phoneNumber") String phoneNumber,
			@RequestParam("date") String date) {
		
		// db insert
		bookingBO.setBooking(name, headcount, day, phoneNumber, date);
		
		// 응답
		Map<String, Object> result = new HashMap<>();
		result.put("code", 200);
		result.put("result", "success");
		
		return result; // JSON String
		
	}
	
	
	//예약 조회 기능 - ajax 요청
	//{"code":200, "result":"success"}
	@ResponseBody
	@PostMapping("/booking/search-reservation")
	public Map<String, Object> searchReserVation(
			@RequestParam("name") String name,
			@RequestParam("phoneNumber") String phoneNumber,
			Model model) {
		
		Booking booking = new Booking();
		
		// db select
		booking = bookingBO.getreserveInfo(name, phoneNumber);
		Map<String, Object> result = new HashMap<>();
		
		
		
		if (booking == null) {
			result.put("code", 300);
			result.put("result", "failed");
		} else {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			String bookingDate = sdf.format(booking.getDate());
			result.put("code", 200);
			result.put("result", "success");
			result.put("booking", booking);
			result.put("bookingDate", bookingDate);
		}
		
		
		
		return result;
		
	}
	
	//예약 삭제 기능 - AJAX 요청
	// {"code":200, "result":"success"}
	@ResponseBody
	@DeleteMapping("/booking/delete-booking")
	public Map<String, Object> deleteBooking(
			@RequestParam("id") int id) {
		
		// db delete
		bookingBO.deleteBookingById(id);
		
		
		Map<String, Object> result = new HashMap<>();
		result.put("code", 200);
		result.put("result", "success");
		
		return result;
		
	}
	
	
	
	
}
