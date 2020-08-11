package com.example.demo;

public class Car {

	private String name; 
	
	private int colorId; 
	
	public Car(String string, int i) {
		// TODO Auto-generated constructor stub
		this.name = string; 
		this.colorId = i; 
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getColorId() {
		return colorId;
	}

	public void setColorId(int colorId) {
		this.colorId = colorId;
	}

}
