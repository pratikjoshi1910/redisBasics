package com.example.sapient.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.example.sapient.entity.Color;

public interface ColorRepository extends PagingAndSortingRepository<Color, UUID> ,JpaSpecificationExecutor<Color>{
	

}
