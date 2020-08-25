package com.example.token.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.token.entity.Source;
import com.example.token.entity.StepMap;

public interface StepMapRepository extends JpaRepository<StepMap, Integer> {

}
