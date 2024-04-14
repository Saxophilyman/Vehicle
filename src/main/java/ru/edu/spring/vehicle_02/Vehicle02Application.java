package ru.edu.spring.vehicle_02;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"ru.edu.spring.vehicle_02"})
public class Vehicle02Application {

	public static void main(String[] args) {
		SpringApplication.run(Vehicle02Application.class, args);
	}

}
