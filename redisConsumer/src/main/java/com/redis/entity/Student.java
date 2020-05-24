package com.redis.entity;

import java.io.Serializable;

import org.springframework.data.redis.core.RedisHash;

@RedisHash("student")
public class Student implements Serializable {

	private String geneder;

	private String id;
	private String name;
	private int grade;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getGrade() {
		return grade;
	}

	public void setGrade(int grade) {
		this.grade = grade;
	}

	public String getGeneder() {
		return geneder;
	}

	public void setGeneder(String geneder) {
		this.geneder = geneder;
	}
}
