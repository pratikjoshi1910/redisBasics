package com.example.sapient.repository;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.example.sapient.entity.Category;
import com.example.sapient.entity.SystemDetails;

public interface CategoryRepository extends PagingAndSortingRepository<Category, UUID> ,JpaSpecificationExecutor<Category>{

	Category save(Category category);


}
