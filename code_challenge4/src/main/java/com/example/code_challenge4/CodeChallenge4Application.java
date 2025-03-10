package com.example.code_challenge4;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.example.code_challenge4.controllers", "com.example.code_challenge4.services", "com.example.code_challenge4.repositories"})
public class CodeChallenge4Application {

	public static void main(String[] args) {
		SpringApplication.run(CodeChallenge4Application.class, args);
	}

}
