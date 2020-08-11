package com.example.test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.MockitoRule;
import org.springframework.beans.factory.annotation.Autowired;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import com.example.demo.service.ProductService;
import com.example.demo.serviceImpl.Drmo;
import com.example.demo.serviceImpl.ProductServiceImpl;

import junit.framework.Assert;

@RunWith(MockitoJUnitRunner.class)
class ThreadTestApplicationTests {

	@Mock
	ProductService productMockService;

	@InjectMocks
	ProductServiceImpl impl;

	@Captor
	ArgumentCaptor<String> acString;
	
	@Captor
	ArgumentCaptor<Drmo> acDrmo;

	@BeforeEach
	public void createMocks() {
		System.out.println("initi");
		MockitoAnnotations.initMocks(this);
	}

	

	@Test
	void checkProductList1() {
		// productMockService = Mockito.mock(ProductServiceImpl.class);
		Mockito.when(productMockService.count(Mockito.any(Drmo.class), Mockito.anyString())).thenReturn(123);
		Integer value = productMockService.count(new Drmo(), "bb");
		verify(productMockService,times(1)).count(acDrmo.capture(), acString.capture());
		System.out.println(acString.getAllValues().get(0));
		Assert.assertEquals(123, value.intValue());
		Assert.assertEquals(acString.getAllValues().get(0), "aa");
	}

}
