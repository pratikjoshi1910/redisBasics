package com.example.sapient.repository;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.example.sapient.entity.Product;
import com.example.sapient.entity.SystemDetails;

public interface SystemDetailsRepo extends PagingAndSortingRepository<SystemDetails, UUID> ,JpaSpecificationExecutor<SystemDetails>{

	SystemDetails findByCode(Long functionality);
	

}
