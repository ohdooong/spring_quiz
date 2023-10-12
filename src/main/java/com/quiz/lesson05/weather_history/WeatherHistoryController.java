package com.quiz.lesson05.weather_history;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.quiz.lesson05.weather_history.bo.WeatherHistoryBO;
import com.quiz.lesson05.weather_history.domain.WeatherHistory;

@RequestMapping("/lesson05/weather_history")
@Controller
public class WeatherHistoryController {
	
	@Autowired
	private WeatherHistoryBO weatherHistoryBO;
	
	
	// url : http://localhost/lesson05/weather_history/history-view
	@GetMapping("/history-view")
	public String weatherMain (	Model model) {
		
		List<WeatherHistory> weatherList = new ArrayList<>();
		weatherList = weatherHistoryBO.getWeatherHistory();
		
		model.addAttribute("weatherhistory", weatherList);
		return "weather_history/weatherMain";
	}
	
	// url : http://localhost/lesson05/weather_history/add-weather-view
	@GetMapping("/add-weather-view")
	public String addWeatherView () {
		return "weather_history/addWeather";
	}
	
	@PostMapping("/add_weather")
	public String addWeather (
			@RequestParam Date date,
			@RequestParam String microDust,
			@RequestParam String weather,
			@RequestParam String temperatures,
			@RequestParam String precipitation,
			@RequestParam String windSpeed) {
		weatherHistoryBO.setWeatherHistory(date,weather, microDust, temperatures, precipitation, windSpeed);
		return "입력성공";
	}
	
	
	
	
	
}
