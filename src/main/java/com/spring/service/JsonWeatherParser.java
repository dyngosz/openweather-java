package com.spring.service;

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
	    
    public Weather getWeather() throws ParseException, JSONException{
    	Weather weather = new Weather();
        Object obj = parser.parse(jsonToParsing);
        
        JSONObject mainJsonObj = (JSONObject) obj;
        JSONObject mainArray = (JSONObject) mainJsonObj.get("main");
        JSONObject cloudsArray = (JSONObject) mainJsonObj.get("clouds");
        JSONObject sysArray = (JSONObject) mainJsonObj.get("sys");

        weather.setTemperature(getTemperatureDescription(mainArray));
        
        return weather;
        
    }
    
    private String getTemperatureDescription(JSONObject jsonObject) throws NumberFormatException, JSONException {
        Double temp = new Double(jsonObject.get("temp").toString());
        return (temp > 0 ? "+" : "") + String.valueOf(Math.round(temp));
    }


}