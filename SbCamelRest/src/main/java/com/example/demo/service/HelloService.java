package com.example.demo.service;

import org.springframework.stereotype.Service;

import com.example.demo.model.RequestDIBBuild;

@Service
public class HelloService {

	public HelloService() {
		
	}
	
	public String hello (RequestDIBBuild requestDIBBuild)
	{
		return " hello tout seul " + requestDIBBuild.getRepInMetada() ; 
	}
	
	
	
}
