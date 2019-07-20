package com.jayesh93.solutions;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class RaterServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(RaterServiceApplication.class, args);
	}

}