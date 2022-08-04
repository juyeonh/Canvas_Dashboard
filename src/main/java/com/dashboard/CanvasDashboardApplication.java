package com.dashboard;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//@EnableAutoConfiguration(exclude={DataSourceAutoConfiguration.class})
@SpringBootApplication
public class CanvasDashboardApplication {

	public static void main(String[] args) {
		SpringApplication.run(CanvasDashboardApplication.class, args);
	}

}
