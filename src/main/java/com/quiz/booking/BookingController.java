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
	@ResponseBody //  @ResponseBody가 있을때는 Model을 사용할 수 없다.  (jsp (VIEW)로 이동 하지 않기 때문)
	@PostMapping("/booking/search-reservation")
	public Map<String, Object> searchReserVation(
			@RequestParam("name") String name,
			@RequestParam("phoneNumber") String phoneNumber
			) {
		
		
		// DB select
		Booking booking = new Booking();
		booking = bookingBO.getreserveInfo(name, phoneNumber);
		
		// 응답값
		// {"code":400, "error_message":"데이터가 존재하지 않습니다."} 혹은
		// {"code":200, "result":{"id":1, "name":...}} 
		Map<String, Object> result = new HashMap<>();
		
		if (booking == null) {
			result.put("code", 400);
			result.put("error_message", "데이터가 존재하지 않습니다.");
		} else {
			result.put("code", 200);
			result.put("result", booking);
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
