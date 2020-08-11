package com.redis.controller;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.redisson.Redisson;
import org.redisson.api.RDelayedQueue;
import org.redisson.api.RLiveObjectService;
import org.redisson.api.RQueue;
import org.redisson.api.RedissonClient;
import org.redisson.api.condition.Conditions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.redis.entity.Student;
import com.redis.repo.StudentRepository;

import io.netty.util.internal.StringUtil;

@RestController
@RequestMapping("/student")
public class RedisController {

	@Autowired
	StudentRepository repository;

	@GetMapping
	void createStudent() {
		RedissonClient redisson = Redisson.create();
		/*
		 * RedissonClient redisson = Redisson.create();
		 * 
		 * RQueue<String> destinationQueue = redisson.getQueue("anyQueue");
		 * 
		 * RDelayedQueue<String> delayedQueue =
		 * redisson.getDelayedQueue(destinationQueue);
		 * 
		 * // move object to destinationQueue in 10 seconds
		 * 
		 * delayedQueue.offer("msg1", 10, TimeUnit.SECONDS);
		 * 
		 * // move object to destinationQueue in 1 minute
		 * 
		 * delayedQueue.offer("msg2", 1, TimeUnit.MINUTES); List<Student> students = new
		 * ArrayList<>();
		 * 
		 * repository.findAll().forEach(students::add); for (Student student1:students)
		 * { System.out.println(student1.getName());
		 * System.out.println(student1.getId());
		 * 
		 * }
		 */
		long startTime = System.currentTimeMillis();
		Random random = new Random();

		RLiveObjectService liveObjectService = redisson.getLiveObjectService();
		List<MyObject> objects1 = (List<MyObject>) liveObjectService.find(MyObject.class,

				Conditions.eq("field1", "value")
						);
		System.out.println("size is " + objects1.get(0).getId());
		System.out.println("size is " + objects1.get(0).getField1());
		MyObject x = liveObjectService.get(MyObject.class,  "993008926");
		long endTime = System.currentTimeMillis();
		System.out.println("total time is " + (endTime - startTime));
		startTime = System.currentTimeMillis();
		MyObject saveObject = new MyObject();
		saveObject.setField1("value");
		saveObject.setField2(7);
		saveObject.setId(Integer.toString(saveObject.hashCode()));
		liveObjectService.persist(saveObject);
		System.out.println("size is " + objects1.size());
		endTime = System.currentTimeMillis();
		System.out.println("total time is " + (endTime - startTime));
		liveObjectService.unregisterClass(MyObject.class);
	}

}
