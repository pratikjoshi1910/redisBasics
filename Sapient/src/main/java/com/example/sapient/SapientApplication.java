package com.example.sapient;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan("com.example.sapient")
public class SapientApplication {

	public static void main(String[] args) {
		SpringApplication.run(SapientApplication.class, args);
		
	}

}
