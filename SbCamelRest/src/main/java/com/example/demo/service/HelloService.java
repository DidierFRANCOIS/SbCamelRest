package com.example.demo.service;

import org.springframework.stereotype.Service;

@Service
public class HelloService {

	public HelloService() {
		// TODO Auto-generated constructor stub
	}
	
	public String hello (String pName)
	{
		return " hello " + pName ; 
	}
	
	
	public String hello02 (String pName ) 
	{ 
		
		return " hello " + pName ;
	}
	
}
