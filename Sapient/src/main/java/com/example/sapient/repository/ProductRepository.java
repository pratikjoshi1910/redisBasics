package com.example.sapient.repository;

import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.example.sapient.entity.Product;
import com.example.sapient.entity.SystemDetails;
import com.example.sapient.resultMapper.BrandProductResult;

@Repository
public interface ProductRepository extends PagingAndSortingRepository<Product, UUID> ,JpaSpecificationExecutor<Product> {

	@Query("select p.productCode as productCode,p.client.code as code from Product p group by code,productCode")
	List<BrandProductResult> getAllProductByProductByClient();
	
	@Query("select p.productCode as productCode,p.category.code as code from Product p group by code,productCode")
	List<BrandProductResult> getAllProductByCategory();
	
	@Query("select p.productCode as productCode,p.color.code as code from Product p group by code,productCode")
	List<BrandProductResult>  getProductByColor();

	Product save(Product product);

	


	
}
