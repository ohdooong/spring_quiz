package com.quiz.weather_history;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.quiz.weather_history.bo.WeatherHistoryBO;
import com.quiz.weather_history.domain.WeatherHistory;

@RequestMapping("/weather_history")
@Controller
public class WeatherHistoryController {
	
	@Autowired
	private WeatherHistoryBO weatherHistoryBO;
	
	
	// url : http://localhost/weather_history/history-view
	@GetMapping("/history-view")
	public String weatherMain (	Model model) {
		
		List<WeatherHistory> weatherHistoryList = new ArrayList<>();
		weatherHistoryList = weatherHistoryBO.getWeatherHistory();
		
		model.addAttribute("weatherhistory", weatherHistoryList);
		return "weather_history/weatherMain";
	}
	
	// url : http://localhost/weather_history/add-weather-view
	@GetMapping("/add-weather-view")
	public String addWeatherView () {
		return "weather_history/addWeather";
	}
	
	@PostMapping("/add_weather")
	public String addWeather (
			//@RequestParam("date") @DateTimeFormat(pattern="yyyy-MM-dd") Date date,
			@RequestParam("date") String date,
			@RequestParam("microDust") String microDust,
			@RequestParam("weather") String weather,
			@RequestParam("temperatures") double temperatures,
			@RequestParam("precipitation") double precipitation,
			@RequestParam("windSpeed") double windSpeed
			) {
		
		// response
		
		
		weatherHistoryBO.setWeatherHistory(date, weather, microDust, temperatures, precipitation, windSpeed);
		return "redirect:/lesson05/weather_history/history-view";
	}
	
	
	
	
	
}
