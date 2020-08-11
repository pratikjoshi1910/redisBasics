package com.example.demo.serviceImpl;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.example.demo.service.ProductService;

@Component
public class ProductServiceImpl implements ProductService{

	@Override
	public Integer count(Drmo name,String value) {
		// TODO Auto-generated method stub
		int value1 = 1234; 
		return value1  ;
	}

}
