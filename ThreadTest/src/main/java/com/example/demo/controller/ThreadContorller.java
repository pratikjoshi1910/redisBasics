package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.service.ProductService;
import com.example.demo.serviceImpl.Drmo;

@RestController
@RequestMapping("/hello")
public class ThreadContorller {
	
	@Autowired
	ProductService service; 
	
	@GetMapping
	public void test()
	{
		service.count(new Drmo(),"bb");
	}
	

}
