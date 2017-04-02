package com.spring.web;

import com.spring.domain.Weather;
import com.spring.service.WeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.json.JSONException;
import java.io.IOException;
import java.text.ParseException;

@RestController
public class WeatherController {
    private final WeatherService weatherService;

    @Autowired
    public WeatherController(WeatherService weatherService) {
        this.weatherService = weatherService;
    }

    @RequestMapping(value = "/weather")
    public Weather currentWeather() throws IOException, ParseException, JSONException, org.json.simple.parser.ParseException {
    	return weatherService.getCurrentWeather("Wroclaw");
    }
}