package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
public class Task_1 {

	public static void main(String[] args) {
		SpringApplication.run(Task_1.class, args);
//		 LocalDate date = java.time.LocalDate.now(); 
//		 System.out.println("####################################\n"+date);
	}

}
