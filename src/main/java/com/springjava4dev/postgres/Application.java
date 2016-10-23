package com.springjava4dev.postgres;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;


@SpringBootApplication
@ComponentScan("com.springjava4dev.postgres.service.impl, com.springjava4dev.postgres.dao.impl,com.springjava4dev.postgres.controller")

public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
					

	}
}
