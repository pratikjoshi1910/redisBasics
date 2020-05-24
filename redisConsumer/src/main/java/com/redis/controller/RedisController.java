package com.redis.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.redis.entity.Student;
import com.redis.repo.StudentRepository;

@RestController
@RequestMapping("/student")
public class RedisController {
	

	@Autowired
	StudentRepository repository;
	
	@GetMapping
	void createStudent ()
	{
		List<Student> students = new ArrayList<>();

		repository.findAll().forEach(students::add);
		for (Student student1:students)
		{
		System.out.println(student1.getName());
		System.out.println(student1.getId());

		}
	}

}
