package com.spring.domain;

public class Weather {

	private String city;
	private String description;
	private String temperature;

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
