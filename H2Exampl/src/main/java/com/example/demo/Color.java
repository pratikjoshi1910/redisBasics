package com.example.demo;

public class Color {

	private String name; 
	
	private int id; 
	public Color(int i, String string) {
		// TODO Auto-generated constructor stub
		this.id = i; 
		this.name = string; 
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

}
