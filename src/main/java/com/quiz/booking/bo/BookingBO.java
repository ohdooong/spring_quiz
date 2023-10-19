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
	
	public List<Booking> getreserveInfo(String name, String phoneNumber){
		return bookingMapper.selectreserveInfo(name, phoneNumber);
	}
	
	
}
