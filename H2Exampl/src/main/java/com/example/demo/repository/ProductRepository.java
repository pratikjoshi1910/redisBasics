package com.example.demo.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Product;

@Repository
public interface ProductRepository
		extends PagingAndSortingRepository<Product, Integer> ,JpaSpecificationExecutor<Product>{
	@Query(
			  value = "SELECT * FROM Product u", 
			  nativeQuery = true)	public Page<Product> getAllProduct(Pageable pageable);


}
