package com.example.sapient.repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.Tuple;

import org.springframework.stereotype.Repository;

import com.example.sapient.entity.Product;

@Repository
public class ProductRepositoryImpl {
	
	@PersistenceContext
	EntityManager em ; 
	
	public List<Map<String, Object>> test ()
	{
		List<String> fields = new ArrayList<>(); 
		fields.add("name");
		fields.add("PRICE");
		fields.add("code");
		
		List<String> field = new ArrayList<>(); 
		field.add("Nike");
		field.add("PRICE");
		field.add("code");
		
		String s = "select  code as code ,price as price, name as name , id as id from product where name IN :name and price > :price GROUP BY code";
		Query products = em.createNativeQuery(s,Tuple.class);
		products.setParameter("name", field);
		products.setParameter("price", 00);
	
		List<Tuple>result = products.getResultList();
		List<Map<String, Object>> results=new ArrayList<>();
		result.forEach(x ->
		{
			Map <String,Object> values = new HashMap<>(); 
			for (String fieldg:fields)
			{
			values.put(fieldg, x.get(fieldg.toUpperCase()));
			
			}
			results.add(values); 
		});
		return results; 
	}

}
