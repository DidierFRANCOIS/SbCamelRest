package com.example.demo;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.support.SpringBootServletInitializer;



@SpringBootApplication
public class SbCamelRestApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(SbCamelRestApplication.class, args);
		
		
	}

	
}
