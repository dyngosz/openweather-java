package com.spring.service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import org.json.JSONException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import com.spring.domain.Weather;

public class JsonWeatherParser {

	private String jsonToParsing;
	private final JSONParser parser = new JSONParser();

	public void setJsonToParsing(String jsonToParsing) {
		this.jsonToParsing = jsonToParsing;
	}

	public Weather getWeather() throws ParseException, JSONException, java.text.ParseException {
		Weather weather = new Weather();
		Object obj = parser.parse(jsonToParsing);

		JSONObject mainJsonObj = (JSONObject) obj;
		JSONObject mainConditionsArray = (JSONObject) mainJsonObj.get("main");
		JSONObject sysArray = (JSONObject) mainJsonObj.get("sys");

		/* Parsing JSONArray */
		JSONArray weatherArray = (JSONArray) mainJsonObj.get("weather");
		Iterator<JSONObject> i = weatherArray.iterator();
		
		while (i.hasNext()) {
			JSONObject arrayValue = (JSONObject) i.next();
			String description = (String) arrayValue.get("description");
			String weatherID = String.valueOf(arrayValue.get("id"));
			weather.setDescription(description);
			weather.setWeatherID(weatherID);
		}

		weather.setTemperature(getTemperatureDescription(mainConditionsArray));
		weather.setHumidity(getJsonNumericObjectDescription(mainConditionsArray, "humidity"));
		weather.setPressure(getJsonNumericObjectDescription(mainConditionsArray, "pressure"));
		weather.setCity(String.valueOf(mainJsonObj.get("name")));

		try {
			/* Get date, sunrise and sunset times from unix epoch values */
			Long sunrise = Long.parseLong(getJsonLongObjectDescription(sysArray, "sunrise"));
			String sunriseTime = new java.text.SimpleDateFormat("HH:mm:ss")
					.format(new java.util.Date(sunrise * 1000));
			
			String today = new java.text.SimpleDateFormat("MM/dd/yyyy")
					.format(new java.util.Date(sunrise * 1000));
			
			Long sunset = Long.parseLong(getJsonLongObjectDescription(sysArray, "sunset"));
			String sunsetTime = new java.text.SimpleDateFormat("HH:mm:ss")
					.format(new java.util.Date(sunset * 1000));
			
			weather.setSunriseTime(sunriseTime);
			weather.setSunsetTime(sunsetTime);
			weather.setDate(today);
			
		} catch (NumberFormatException nfe) {
			nfe.printStackTrace();
		}

		return weather;

	}

	private String getTemperatureDescription(JSONObject jsonObject) throws NumberFormatException, JSONException {
		Double temp = new Double(jsonObject.get("temp").toString());
		return (temp > 0 ? "+" : "") + String.valueOf(Math.round(temp));
	}

	private String getJsonNumericObjectDescription(JSONObject jsonObject, String valueName) {
		Double jsonValue = new Double(jsonObject.get(valueName).toString());
		return String.valueOf(jsonValue);
	}
	
	private String getJsonLongObjectDescription(JSONObject jsonObject, String valueName) {
		Long jsonValue = new Long(jsonObject.get(valueName).toString());
		return String.valueOf(jsonValue);
	}

}