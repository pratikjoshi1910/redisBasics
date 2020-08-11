package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Product;
import com.example.demo.repository.ProductRepository;
import com.example.demo.service.Employee;
import com.example.demo.service.EmployeeManager;
import com.example.demo.service.ExampleServicce;

import ch.qos.logback.core.util.ContentTypeUtil;

@RestController
@RequestMapping(value = "/product")
public class ProductController {
	
	@Autowired
	ProductRepository pr; 
	
	@Autowired
    ExampleServicce es;
	
	@Autowired
	EmployeeManager manager;
	
	public boolean checkValue ()
	{
		throw new IndexOutOfBoundsException();
	}
	
	@GetMapping(consumes = {MediaType.ALL_VALUE}, 
                produces = {MediaType.ALL_VALUE })
	public ResponseEntity<Product> test()
	{System.out.println("inside");
	   UUID uuid = UUID.randomUUID();
	   System.out.println(uuid);
		Product product  = new Product(); 
		product.setId(UUID.fromString("6dfd9860abea4beaa109a1818d6c66ae"));
		product.setImagePath("c:ff");
		product.setName("name");
		pr.save(product);
		return new ResponseEntity<Product>(product,HttpStatus.OK);
		
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Page<Product>> getAllProduct (@PathVariable Long id) throws Exception
	
	{
		Object example = null;
		ExampleMatcher matcher = null;
		List<Product> x = pr.findAll(new Specification<Product>() {

			@Override
			public Predicate toPredicate(Root<Product> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
				// TODO Auto-generated method stub
				List<Predicate> predicates = new ArrayList<>();
				predicates.add(criteriaBuilder.or(criteriaBuilder.equal(root.get("name"), "abc")));
				return criteriaBuilder.and(predicates.toArray(new Predicate[predicates.size()]));
			}
		});
		System.out.println(x.size());
		return new ResponseEntity(manager.getEmployeeById(id), HttpStatus.OK);
		//es.test();
		
		 
		/*
		 * Pageable sortedByName = PageRequest.of(0, 3, Sort.by("name")); return new
		 * ResponseEntity<Page<Product>>(pr.getAllProduct(sortedByName), HttpStatus.OK);
		 */
		 
		
	}
}
