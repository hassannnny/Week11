package com.example.UserDataAPI;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication()
public class UserDataApiApplication extends SpringBootServletInitializer {
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		return builder.sources(UserDataApiApplication.class);
	}

	public static void main(String[] args) {
		SpringApplication.run(UserDataApiApplication.class, args);
	}

}
