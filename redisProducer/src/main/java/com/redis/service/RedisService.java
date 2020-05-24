package com.redis.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.redis.entity.Student;
import com.redis.repo.StudentRepository;

@Service
public class RedisService {
	
	@Autowired
	StudentRepository studentRepository; 
	
	public void saveStudent (Student student)
	{
		studentRepository.save(student);
	}

}
