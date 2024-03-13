package com.rest.crud;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Lesson04Application {

	public static void main(String[] args) {
		SpringApplication.run(Lesson04Application.class, args);
	}

	@Bean
	CommandLineRunner runner(String[] args) {
		return runner ->System.out.println("Running Successfuly!");
	}
}
