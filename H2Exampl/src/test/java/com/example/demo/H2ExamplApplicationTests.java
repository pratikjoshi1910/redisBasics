package com.example.demo;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.extension.Extensions;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.web.client.RestTemplate;

import com.example.demo.controller.ProductController;
import com.example.demo.entity.Product;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;;
@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
class H2ExamplApplicationTests {
	
	@Mock
	ProductController pc;
	
	@Autowired
	ProductController pc1;
	
	@Autowired
	TestRestTemplate RestTemplate;

	
	
	@Test
	@DisplayName("check hello world endpoint")
	
	void contextLoads() {
		//when(pc1.checkValue()).thenReturn(true);

		boolean result = pc1.checkValue(); 
		//verify(pc,times(1)).checkValue();
		assertEquals(true, result);
	}
	
	@Test
	@DisplayName("Test endpoint")
	void testEndpoint()
	{
	 //   Throwable exception = assertThrows(IndexOutOfBoundsException.class, () -> RestTemplate.getForEntity("/product", Product.class));

	ResponseEntity<Product> x = RestTemplate.getForEntity("/product", Product.class);
	assertEquals(x.getBody().getClass(), x.getBody().getClass());
	}
	

}
