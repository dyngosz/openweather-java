package com.spring.service;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.text.ParseException;
import java.util.Properties;

import org.json.JSONException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.spring.domain.Weather;

@Service
public class WeatherServiceImpl implements WeatherService{

	@Value("${app.id:89d42bb4fd3fcf3689611dad9a240353}")
    private String AppID;
    private final JsonWeatherParser parser = new JsonWeatherParser();

    @Override
    public Weather getCurrentWeather(String city) throws IOException, ParseException, JSONException, org.json.simple.parser.ParseException {
        System.out.println("COS");
    	return getWeatherFromJson(getJsonFromServer(city));
    }

    private Weather getWeatherFromJson(String json) throws ParseException, org.json.simple.parser.ParseException, JSONException {
        parser.setJsonToParsing(json);
        return parser.getWeather();
    }

    private String getJsonFromServer(String city) throws IOException {

        String result = "";

        URL url = new URL("http://api.openweathermap.org/data/2.5/weather?q="
                + city
                + "&APPID="
                + AppID
                + "&units=metric");
        URLConnection urlConnection = url.openConnection();
        BufferedReader in = new BufferedReader(new InputStreamReader(
                urlConnection.getInputStream()));
        String inputLine;
        while ((inputLine = in.readLine()) != null) {
            result += result.concat(inputLine);
        }
        in.close();
        return result;
    }
	

}
