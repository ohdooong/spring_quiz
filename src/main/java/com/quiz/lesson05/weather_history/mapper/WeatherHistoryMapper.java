package com.quiz.lesson05.weather_history.mapper;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.quiz.lesson05.weather_history.domain.WeatherHistory;

@Repository
public interface WeatherHistoryMapper {

	public List<WeatherHistory> selectWeatherHistory();
	
	public void insertWeatherHistory(
			@Param ("date") Date date,
			@Param ("microDust") String microDust,
			@Param ("weather") String weather,
			@Param ("temperatures") String temperatures,
			@Param ("precipitation") String precipitation,
			@Param ("windSpeed") String windSpeed);
	
}
