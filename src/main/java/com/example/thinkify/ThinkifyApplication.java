package com.example.thinkify;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
public class ThinkifyApplication {

	public static void main(String[] args) {
		SpringApplication.run(ThinkifyApplication.class, args);
	}
	
}
