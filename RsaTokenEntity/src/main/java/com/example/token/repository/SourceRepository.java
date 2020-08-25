package com.example.token.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.token.entity.Source;

public interface SourceRepository extends JpaRepository<Source, Integer> {

}
