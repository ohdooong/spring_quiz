package com.quiz.booking.bo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quiz.booking.domain.Booking;
import com.quiz.booking.mapper.BookingMapper;

@Service
public class BookingBO {
	
	@Autowired
	private BookingMapper bookingMapper;
	
	// input : x
	// output : List<Booking>
	
	public List<Booking> getBookingList() {
		return bookingMapper.selectBookingList();
	}
	
	// input : int id
	// output : x
	public void deleteBookingById(int id) {
		bookingMapper.deleteBookingById(id);
	}
	
	// input : ~~
	// output : x
	public void setBooking(String name, int headcount, int day, String phoneNumber, String date) {
		bookingMapper.insertBooking(name, headcount, day, phoneNumber, date);
	}
	
	// input: name, phoneNumber     	output : Booking(null or Booking)
	public Booking getreserveInfo(String name, String phoneNumber){
		List<Booking> bookingList = bookingMapper.selectreserveInfo(name, phoneNumber);
		// 0  1(최신) 
		// Mybatis는 결과가 없으면 empty로 반환한다. 즉 널이 아니다. bookingList = []와 같은 식으로.
		
		if (bookingList.isEmpty()) {
			return null;
		}
			
		// 리스트가 비어있지 않으면 마지막 객체 리턴
		return bookingList.get(bookingList.size() - 1);
	}
	
	
}
