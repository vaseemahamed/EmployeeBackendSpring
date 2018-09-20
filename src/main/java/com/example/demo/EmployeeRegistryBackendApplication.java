package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;


@SpringBootApplication(scanBasePackages = { "com.example" })
@EnableMongoRepositories("com.example.repository")
@ComponentScan({ "com.example" })
public class EmployeeRegistryBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmployeeRegistryBackendApplication.class, args);
	}
}
