package com.spring.service;

import java.io.IOException;
import java.text.ParseException;

import org.json.JSONException;

import com.spring.domain.Weather;

public interface WeatherService {
	Weather getCurrentWeather(String city) throws IOException, ParseException, JSONException, org.json.simple.parser.ParseException;
}
