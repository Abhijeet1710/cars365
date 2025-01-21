package com.cars365.Cars365Apg;

import com.cars365.Cars365Apg.configs.JwtValidationFilter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class Cars365ApgApplication {

	public static void main(String[] args) {
		SpringApplication.run(Cars365ApgApplication.class, args);
	}

//	@Bean
//	public JwtValidationFilter jwtValidationFilter() {
//		return new JwtValidationFilter();
//	}

	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}

}
