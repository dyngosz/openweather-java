package com.spring.domain;

public class Weather {

	private String city;
	private String description;
	private String temperature;
	private String humidity;
	private String pressure;
	private String weatherID;
	private String sunriseTime;
	private String sunsetTime;
	private String date;

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getWeatherID() {
		return weatherID;
	}

	public String getSunriseTime() {
		return sunriseTime;
	}

	public void setSunriseTime(String sunriseTime) {
		this.sunriseTime = sunriseTime;
	}

	public String getSunsetTime() {
		return sunsetTime;
	}

	public void setSunsetTime(String sunsetTime) {
		this.sunsetTime = sunsetTime;
	}

	public void setWeatherID(String weatherID) {
		this.weatherID = weatherID;
	}

	public String getHumidity() {
		return humidity;
	}

	public void setHumidity(String humidity) {
		this.humidity = humidity;
	}

	public String getPressure() {
		return pressure;
	}

	public void setPressure(String pressure) {
		this.pressure = pressure;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getTemperature() {
		return temperature;
	}

	public void setTemperature(String temperature) {
		this.temperature = temperature;
	}

	@Override
	public String toString() {
		StringBuffer buffer = new StringBuffer();
		buffer.append("City: " + city + ";");
		buffer.append("Temperature: " + temperature + ";");
		buffer.append("Description: " + description + ";");
		return buffer.toString();
	}
}
