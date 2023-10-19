package com.quiz.booking.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.quiz.booking.domain.Booking;

@Repository
public interface BookingMapper {

	
	public List<Booking> selectBookingList();
	
	public void deleteBookingById(int id);
	
	public void insertBooking(
			@Param("name") String name,
			@Param("headcount") int headcount,
			@Param("day") int day,
			@Param("phoneNumber") String phoneNumber,
			@Param("date") String date
							);
	
	public Booking selectreserveInfo(
			@Param("name") String name,
			@Param("phoneNumber") String phoneNumber);
	
}
