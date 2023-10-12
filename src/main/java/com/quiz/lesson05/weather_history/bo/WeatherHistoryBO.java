package com.quiz.lesson05.weather_history.bo;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quiz.lesson05.weather_history.domain.WeatherHistory;
import com.quiz.lesson05.weather_history.mapper.WeatherHistoryMapper;

@Service
public class WeatherHistoryBO {
	
	@Autowired
	private WeatherHistoryMapper weatherHistoryMapper;
	
	
	public List<WeatherHistory> getWeatherHistory() {
		return weatherHistoryMapper.selectWeatherHistory();
	}
	
	public void setWeatherHistory(Date date, String weather, String microDust, String temperatures, String precipitation, String windSpeed) {
		weatherHistoryMapper.insertWeatherHistory(date,weather, microDust,temperatures,precipitation,windSpeed);
	}
	
	
	
	
}
