package com.spring.mvc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import com.spring.web.WeatherController;

@SpringBootApplication
@EnableAutoConfiguration
@ComponentScan({"com.spring.domain", "com.spring.service", "com.spring.web"})
public class OpenWeatherApplication {

	public static void main(String[] args) {
		SpringApplication.run(OpenWeatherApplication.class, args);
	}
}
