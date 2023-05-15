package com.web.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
public class TakeHomeApplication {

	public static void main(String[] args) {
		SpringApplication.run(TakeHomeApplication.class, args);
	}

}
