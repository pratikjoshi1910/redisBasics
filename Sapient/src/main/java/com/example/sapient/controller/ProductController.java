package com.example.sapient.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.sapient.repository.ProductRepositoryImpl;
import com.example.sapient.repository.Test;
import com.example.sapient.resultMapper.BrandProductResult;

import java.util.List;
import java.util.Map;

import javax.persistence.Tuple;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;
@RestController
@RequestMapping("/product")
public class ProductController {
	
	@Autowired
	ProductRepositoryImpl productRepo;
	
	Logger logger = LoggerFactory.getLogger(ProductController.class);
	
	@GetMapping
	public List<Map<String, Object>> test()
	{
		logger.info("got request");

		return productRepo.test();
		
	}
	

}
