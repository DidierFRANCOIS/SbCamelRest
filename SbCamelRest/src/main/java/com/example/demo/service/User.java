package com.example.demo.service;

import java.util.Map;
import java.util.TreeMap;

public class User {

	private int id;
	private String name;
	private final Map<Integer , Comment> commentsUser = new TreeMap<Integer, Comment>(); 

	public User() {
	}

	public User(int id, String name) {
		this.id = id;
		this.name = name;
	}


	public void addComment ( int id , Comment comment )
	{

		commentsUser.put(id, comment);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
